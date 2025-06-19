package com.example.e_grampanchayat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class admin extends AppCompatActivity {
    EditText emaila,passworda;
    TextView newaccount;
    Button loginbtnadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        loginbtnadmin=findViewById(R.id.loginButtonadmin);


    }
}