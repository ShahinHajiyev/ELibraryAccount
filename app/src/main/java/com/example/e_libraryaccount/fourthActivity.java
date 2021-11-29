package com.example.e_libraryaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class fourthActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        String contentOfBooks = getIntent().getStringExtra(thirdActivity.CONTENT);

        switch (contentOfBooks) {
            case thirdActivity.PYTHON:
                openContent("1.pdf");
                break;
        }


    }

    public void openContent(String name){
        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset(name).load();
    }
}