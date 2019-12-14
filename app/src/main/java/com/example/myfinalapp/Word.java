package com.example.myfinalapp;

public class Word {

    private String mProductName;
    private String mProductPrice;

    public Word(String productName, String productPrice) {
        mProductName = productName;
        mProductPrice = productPrice;
    }

    public String getFoodName() {
        return mProductName;
    }

    public String getFoodPrice() {
        return mProductPrice;
    }
}
