package com.example.e_libraryaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thirdActivity extends AppCompatActivity {

    ImageView bookView;
    TextView contentView;
    String acceptedBook;
    public static final String CONTENT = "content";
    public static final String PYTHON = "python";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        bookView = findViewById(R.id.bookView);
        contentView = findViewById(R.id.contentView);

         acceptedBook =getIntent().getStringExtra(secondActivity.BOOKS);


        switch (acceptedBook) {
            case secondActivity.BOOK1:
                try {
                    getBookContent("stupids.txt", contentView,R.drawable.python);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void getBookContent(String txt, TextView textview, int image) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(txt)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        textview.setText(text);
        textview.setMovementMethod(new ScrollingMovementMethod());
        bookView.setImageResource(image);

    }

    public void read(View view){
        Intent intent = new Intent(this,fourthActivity.class);

        if (acceptedBook.equals(secondActivity.BOOK1)) {
            intent.putExtra(CONTENT, PYTHON);
            startActivity(intent);
        }

    }
}