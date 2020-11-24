package com.example.registrationandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button lp_register, lp_login;
    EditText lp_username, lp_pass;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        dataBaseHelper = new DataBaseHelper(this);
        lp_username = (EditText)findViewById(R.id.editTextlplogin);
        lp_pass = (EditText)findViewById(R.id.editTextlppassword);
        lp_login = (Button)findViewById(R.id.buttonLogin);
        lp_register = (Button)findViewById(R.id.buttonbacktoLogin);

        lp_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (LoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lp_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = lp_username.getText().toString();
                String pass = lp_pass.getText().toString();

                Boolean checklogin = dataBaseHelper.CheckLogin(username, pass);
                if (checklogin == true) {
                    Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage.this, HomePage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginPage.this, "Invalid login or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}