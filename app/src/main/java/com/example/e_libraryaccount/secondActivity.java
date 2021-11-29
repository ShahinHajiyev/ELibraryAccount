package com.example.e_libraryaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    public static final String BOOKS = "books";
    public static final String BOOK1 = "book1";

    TextView python;
    TextView c;
    TextView dummy;
    TextView stupid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        python = findViewById(R.id.python);
        python.setText(getString(R.string.content));

        c = findViewById(R.id.c);
        c.setText(getString(R.string.test));

        dummy = findViewById(R.id.dummy);
        c.setText(getString(R.string.c));

        stupid = findViewById(R.id.stupid);
        stupid.setText(getString(R.string.content));


    }

    public void click(View view){
        Intent intent = new Intent(this,thirdActivity.class);
        intent.putExtra(BOOKS,BOOK1);
        startActivity(intent);
    }
}