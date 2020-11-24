package com.example.registrationandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText t_username, t_password, t_cpassword;
    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper = new DataBaseHelper(this);
        t_username = (EditText)findViewById(R.id.editTextTextPersonName);
        t_password = (EditText)findViewById(R.id.editTextNumberPassword);
        t_cpassword = (EditText)findViewById(R.id.editTextNumberPassword2);
        register = (Button) findViewById(R.id.buttonRegister);
        login = (Button) findViewById(R.id.buttonLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = t_username.getText().toString();
                String password = t_password.getText().toString();
                String cpassword = t_cpassword.getText().toString();

                if (username.equals("") || password.equals("") || cpassword.equals("")) {
                    Toast.makeText(MainActivity.this, "Fields Required", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(password.equals(cpassword)) {
                        Boolean checkusername = dataBaseHelper.CheckUsername(username);
                        if (checkusername == true) {
                            Boolean insert = dataBaseHelper.Insert(username, password);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                                t_username.setText("");
                                t_password.setText("");
                                t_cpassword.setText("");
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Username has been taken", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                                Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }
}