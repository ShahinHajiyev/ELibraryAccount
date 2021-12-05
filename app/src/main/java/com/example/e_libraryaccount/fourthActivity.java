package com.example.e_libraryaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class fourthActivity extends AppCompatActivity {

    PDFView pdfView;
    CheckBox checkBox;
    SeekBar seekBar;

    private int color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        askPermission(this);

        String contentOfBooks = getIntent().getStringExtra(thirdActivity.CONTENT);

        checkBox = findViewById(R.id.checkBox);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(255);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_BRIGHTNESS, progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    seekBar.setVisibility(View.VISIBLE);
                }
                else {
                    seekBar.setVisibility(View.INVISIBLE);

                }
            }
        });

        switch (contentOfBooks) {
            case thirdActivity.PYTHON:
                openContent("1.pdf");
                break;
            case thirdActivity.SURVIVE:
                openContent("survive.pdf");
                break;
            case thirdActivity.IDIOTISM:
                openContent("idiots.pdf");
                break;
            case thirdActivity.STUPIDITISM:
                openContent("english.pdf");
                break;

        }
    }

    public void openContent(String name){
        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset(name)
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(1)
                .load();

    }

    public void askPermission(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (Settings.System.canWrite(context));
            else{
                Intent i = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                context.startActivity(i);
            }


        }
    }


}