package com.example.myfinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btnMove, btnMove2, btnMove3;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnMove = findViewById(R.id.btn_move_intent);
        btnMove.setOnClickListener(this);

        btnMove2 = findViewById(R.id.btn2);
        btnMove2.setOnClickListener(this);

        btnMove3 = findViewById(R.id.btn3);
        btnMove3.setOnClickListener(this);

        teks=(TextView)findViewById(R.id.font);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"font/Sacramento-Regular.ttf");
        teks.setTypeface(customfont);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_intent:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, FourthActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, FifthActivity.class));
                break;
        }
    }


}
