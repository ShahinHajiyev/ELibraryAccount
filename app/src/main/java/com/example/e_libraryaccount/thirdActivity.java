package com.example.e_libraryaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
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
    public static final String SURVIVE = "survive";
    public static final String IDIOTISM = "idiot";
    public static final String STUPIDITISM = "stupid";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        bookView = findViewById(R.id.bookView);
        contentView = findViewById(R.id.contentView);

         acceptedBook =getIntent().getStringExtra(secondActivity.BOOKS);


        switch (acceptedBook) {
            case secondActivity.BOOK_PYTHON:
                try {
                    getBookContent("python.txt", contentView,R.drawable.python);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case secondActivity.BOOK_SURVIVE:
                try {
                    getBookContent("survive.txt",contentView,  R.drawable.survive);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case secondActivity.BOOK_IDIOTS:
                try {
                    getBookContent("idiots.txt", contentView, R.drawable.guideofidiot);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case secondActivity.BOOK_STUPIDS:
                try {
                    getBookContent("stupids.txt",contentView,R.drawable.page);
                    break;
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
                    Log.e(getString(R.string.notFoundErrorTag), getString(R.string.notFoundError));
                }
            }
        }

        textview.setText(text);
        textview.setMovementMethod(new ScrollingMovementMethod());
        bookView.setImageResource(image);

    }

    public void read(View view){
        Intent intent = new Intent(this,fourthActivity.class);

        if (acceptedBook.equals(secondActivity.BOOK_PYTHON)) {
            intent.putExtra(CONTENT, PYTHON);
            startActivity(intent);
        }

        else if (acceptedBook.equals(secondActivity.BOOK_SURVIVE)) {
            intent.putExtra(CONTENT, SURVIVE);
            startActivity(intent);
        }

        else if (acceptedBook.equals(secondActivity.BOOK_IDIOTS)) {
            intent.putExtra(CONTENT, IDIOTISM);
            startActivity(intent);
        }

        else if (acceptedBook.equals(secondActivity.BOOK_STUPIDS)) {
            intent.putExtra(CONTENT, STUPIDITISM);
            startActivity(intent);
        }



    }
}