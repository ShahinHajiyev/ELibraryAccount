package com.example.e_libraryaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    public static final String BOOKS = "books";
    public static final String BOOK_PYTHON = "book1";
    public static final String BOOK_SURVIVE = "book2";
    public static final String BOOK_STUPIDS = "book3";
    public static final String BOOK_IDIOTS = "book4";

    TextView python;
    TextView c;
    TextView dummy;
    TextView stupid;
    public static final String SHARED = "prefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        python = findViewById(R.id.python);
        python.setText(getString(R.string.content));

        c = findViewById(R.id.c);
        c.setText(getString(R.string.test));

        dummy = findViewById(R.id.dummy);
        dummy.setText(getString(R.string.c));

        stupid = findViewById(R.id.stupid);
        stupid.setText(getString(R.string.content));


    }

    public void clickPython(View view){
        Intent intent = new Intent(this,thirdActivity.class);
        intent.putExtra(BOOKS,BOOK_PYTHON);
        startActivity(intent);
    }

    public void clickSurvive(View view){
        Intent intent = new Intent(this,thirdActivity.class);
        intent.putExtra(BOOKS,BOOK_SURVIVE);
        startActivity(intent);
    }

    public void clickStupids(View view){
        Intent intent = new Intent(this,thirdActivity.class);
        intent.putExtra(BOOKS,BOOK_STUPIDS);
        startActivity(intent);
    }

    public void clickIdiots(View view){
        Intent intent = new Intent(this,thirdActivity.class);
        intent.putExtra(BOOKS,BOOK_IDIOTS);
        startActivity(intent);
    }

    public void logOut(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences(SHARED, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();
    }
}