package com.example.personalcookbookapp.ui.login;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personalcookbookapp.DataBase.DBHelper;
import com.example.personalcookbookapp.Activities.HomeActivity;
import com.example.personalcookbookapp.R;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button loginButton;
    DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Log In Page");

        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);
        loginButton = findViewById(R.id.btn_login);
        dbHelper = new DBHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "All fields must be filled-out.", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkUserPass = dbHelper.checkUsernamePassword(user, pass);
                    if (checkUserPass) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("username", user);
                        editor.apply();

                        Toast.makeText(LoginActivity.this, "You have successfully logged in.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    } else {
                        Toast.makeText(LoginActivity.this, "This user does not exist. Sign up instead.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}