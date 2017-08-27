package com.apps.square.mercato.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.square.mercato.R;
import com.apps.square.mercato.models.LoginModel;
import com.apps.square.mercato.tools.APIManager;
import com.apps.square.mercato.tools.DataManager;
import com.apps.square.mercato.tools.ValidationManager;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.File;
import java.io.FileNotFoundException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class LoginScan extends AppCompatActivity {


    Button btn_login;
    EditText email,password;

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_scan);
        ImageView scan = (ImageView) findViewById(R.id.scan);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

        btn_login=(Button)findViewById(R.id.button_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ValidationManager.validateEmptyFields(LoginScan.this,email,password)){
                APIManager.LoginUser(LoginScan.this,email.getText().toString(),password.getText().toString(),
                        new APIManager.ResponseListener<LoginModel>() {
                            @Override
                            public void done(LoginModel dataModel) {

                                DataManager.setStringSetting(LoginScan.this,"LoginKey",email.getText().toString());
                                Toast.makeText(LoginScan.this, DataManager.getStringSetting(LoginScan.this,"LoginKey","")+"", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(LoginScan.this,HomeActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(i);

                            }

                            @Override
                            public void failed(boolean fromConnection) {

                            }
                        });}
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginScan.this,Scan_QRCode.class);
                startActivity(i);
            }
        });

    }

}
