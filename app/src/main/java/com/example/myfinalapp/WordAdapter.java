package com.example.myfinalapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView foodTextView=(TextView) listItemView.findViewById(R.id.product_text_view);
        foodTextView.setText(currentWord.getFoodName());

        TextView priceTextView=(TextView) listItemView.findViewById(R.id.price_text_view);
        priceTextView.setText(currentWord.getFoodPrice());

        return listItemView;

    }
}
