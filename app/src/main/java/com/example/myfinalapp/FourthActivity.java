package com.example.myfinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //create an arraylist of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Lip Gloss", "Rp 70.000"));
        words.add(new Word("Lip Cream", "Rp 80.000"));
        words.add(new Word("Foundation", "Rp 150.000"));
        words.add(new Word("Eyeshadow", "Rp 100.000"));
        words.add(new Word("Blush On", "Rp 50.000"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
