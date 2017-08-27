package com.apps.square.mercato.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.Toast;

import com.apps.square.mercato.R;
import com.apps.square.mercato.models.AddReviewsModel;
import com.apps.square.mercato.models.QRCodeModel;
import com.apps.square.mercato.tools.APIManager;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scan_QRCode extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);
    }

    @Override
    public void handleResult(Result result) {
        Log.v("TAG", result.getText()); // Prints scan results
        Log.v("TAG", result.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);

        APIManager.getQRCode(Scan_QRCode.this,result.getText(), new APIManager.ResponseListener<QRCodeModel>() {
            @Override
            public void done(QRCodeModel dataModel) {
                if (dataModel.getApi_status()==1){
                    if (dataModel.getCode()==9000){
                        Intent i=new Intent(Scan_QRCode.this,LoginWithPassword.class);
                        startActivity(i);
                    }else if (dataModel.getCode()==9001){
                        Intent i=new Intent(Scan_QRCode.this,Register.class);
                        startActivity(i);
                    }
                }else if (dataModel.getApi_status()==0){
                    Intent i=new Intent(Scan_QRCode.this,LoginScan.class);
                    startActivity(i);
                }
            }

            @Override
            public void failed(boolean fromConnection) {

            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }
}
