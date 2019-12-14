package com.example.myfinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_Move;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Move = findViewById(R.id.btn_continue);
        btn_Move.setOnClickListener(this);

        teks=(TextView)findViewById(R.id.font);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"font/Sacramento-Regular.ttf");
        teks.setTypeface(customfont);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_continue:
                startActivity(new Intent(this, SecondActivity.class));
                break;
        }
    }


}
