package com.example.ahmedsalamony.mercato.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.models.RegisterModel;
import com.example.ahmedsalamony.mercato.tools.APIManager;
import com.example.ahmedsalamony.mercato.tools.ValidationManager;

public class Register extends AppCompatActivity {

    EditText name,email,password,confirmpassword,phone,birthday;
    String resultDate;
    private int mYear, mMonth, mDay;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        confirmpassword=(EditText)findViewById(R.id.confirmpassword);
        phone=(EditText)findViewById(R.id.phone);
        birthday=(EditText)findViewById(R.id.birthday);
        register=(Button)findViewById(R.id.button_register);

        ImageView menu=(ImageView)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Register.this,LoginScan.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                resultDate=year+"-"+monthOfYear+"-"+dayOfMonth;
                                birthday.setText(resultDate);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ValidationManager.validateEmptyFields(Register.this,name,email,password,birthday,phone)){
                APIManager.registerUser(Register.this,name.getText().toString(),email.getText().toString(),
                        password.getText().toString(),birthday.getText().toString(),
                        phone.getText().toString(), new APIManager.ResponseListener<RegisterModel>() {
                            @Override
                            public void done(RegisterModel dataModel) {
                                Toast.makeText(Register.this,  dataModel.getApi_status()+"registered success", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void failed(boolean fromConnection) {
                                Toast.makeText(Register.this,  "failed", Toast.LENGTH_SHORT).show();
                            }
                        });}

            }
        });
    }
}
