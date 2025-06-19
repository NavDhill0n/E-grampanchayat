package com.example.e_grampanchayat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private EditText emailTextView, passwordTextView;
    private Button Btn;
    TextView loginr;

    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth = FirebaseAuth.getInstance();
        loginr=findViewById(R.id.loginrText);
        loginr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logini=new Intent(register.this,login.class);
                startActivity(logini);
            }
        });


        emailTextView = findViewById(R.id.emailr);
        passwordTextView = findViewById(R.id.passwordr);
        Btn = findViewById(R.id.registerbtn);



        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }
      private void registerNewUser()
        {

            // show the visibility of progress bar to show loading


            // Take the value of two edit texts in Strings
            String email, password;
            email = emailTextView.getText().toString();
            password = passwordTextView.getText().toString();

            // Validations for input email and password
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(),
                                "Please enter email!!",
                                Toast.LENGTH_LONG)
                        .show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(),
                                "Please enter password!!",
                                Toast.LENGTH_LONG)
                        .show();
                return;
            }

            // create new user or register new user
            mAuth
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                                // hide the progress bar


                                // if the user created intent to login activity
                                Intent intent
                                        = new Intent(register.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else {

                                // Registration failed
                                Toast.makeText(
                                                getApplicationContext(),
                                                "Registration failed!!"
                                                        + " Please try again later",
                                                Toast.LENGTH_LONG)
                                        .show();

                                // hide the progress bar

                            }
                        }
                    });
        }
    }
