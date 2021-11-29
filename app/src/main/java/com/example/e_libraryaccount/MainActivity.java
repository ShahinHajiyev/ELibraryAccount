package com.example.e_libraryaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText log;
    EditText pass;
    Login login;
    User user;
    String first;
    String second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void go(View view){
        Intent intent = new Intent(this, secondActivity.class);
        log = findViewById(R.id.loginInput);
        pass = findViewById(R.id.passwordInput);

        first = log.getText().toString();
        second = pass.getText().toString();

        user = new User(first,second);
        login = new Login();

        if(login.isLog(user)) {

            startActivity(intent);
            System.out.println("yes");

        }
    }
}