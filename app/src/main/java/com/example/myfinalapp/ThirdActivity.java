package com.example.myfinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.net.Uri;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    int quantity = 2;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        teks=(TextView)findViewById(R.id.font);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"font/Sacramento-Regular.ttf");
        teks.setTypeface(customfont);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    /**
     * This method is called when the minus button is clicked.
     */
    public void dec (View view) {
        if (quantity==1){
            Toast.makeText(this, "You can't have less than 1 product", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity-1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void inc (View view) {
        if (quantity==100){
            Toast.makeText(this, "You can't have more than 100 products", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Mengambil nama user
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //Figure out if the user wants lipgloss
        CheckBox lipGlossCheckbox = (CheckBox) findViewById(R.id.lipgloss_checkbox);
        boolean hasLipGloss = lipGlossCheckbox.isChecked();

        //Figure out if the user wants lipcream
        CheckBox lipCreamCheckbox = (CheckBox) findViewById(R.id.lipcream_checkbox);
        boolean hasLipCream = lipCreamCheckbox.isChecked();

        //Figure out if the user wants foundation
        CheckBox foundationCheckbox = (CheckBox) findViewById(R.id.foundation_checkbox);
        boolean hasFoundation = foundationCheckbox.isChecked();

        //Figure out if the user wants eyeshadow
        CheckBox eyeshadowCheckbox = (CheckBox) findViewById(R.id.eyeshadow_checkbox);
        boolean hasEyeshadow = eyeshadowCheckbox.isChecked();

        //Figure out if the user wants blushon
        CheckBox blushCheckbox = (CheckBox) findViewById(R.id.blush_checkbox);
        boolean hasBlush = blushCheckbox.isChecked();

        int price = calculatePrice(hasLipGloss, hasLipCream, hasFoundation, hasEyeshadow, hasBlush);
        String priceMessage = createOrderSummary(name, price, hasLipGloss, hasLipCream, hasFoundation, hasEyeshadow, hasBlush);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Make Up Order For : " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage );
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    //Calculate the price order
    //return total price
    private int calculatePrice(boolean addLipgloss, boolean addLipcream, boolean addFoundation,
                               boolean addEyeshadow, boolean addBlush){
        int basePrice = 0;

        if (addLipgloss){
            basePrice = basePrice+70000;
        }

        if (addLipcream){
            basePrice = basePrice+80000;
        }
        if (addFoundation){
            basePrice = basePrice+150000;
        }
        if (addEyeshadow){
            basePrice = basePrice+100000;
        }
        if (addBlush){
            basePrice = basePrice+50000;
        }

        return quantity*basePrice;
    }

    //Create summary of order
    //param name the customer
    //param price the order
    //param addWhippedCream is whether or not the user want whipped cream topping
    //return the text summary
    private String createOrderSummary(String name, int price, boolean addLipgloss, boolean addLipcream,
                                      boolean addFoundation, boolean addEyeshadow, boolean addBlush){
        String priceMessage = "Hi beautiful, " + name;
        priceMessage += "\nBuy the Lip Gloss product? " + addLipgloss;
        priceMessage += "\nBuy the Lip Cream product? " + addLipcream;
        priceMessage += "\nBuy the Foundation product? " + addFoundation;
        priceMessage += "\nBuy the Eyeshadow product? " + addEyeshadow;
        priceMessage += "\nBuy the Blush product? " + addBlush;
        priceMessage += "\nQuantity = " + quantity;
        priceMessage += "\nTotal = Rp " + calculatePrice(addLipgloss, addLipcream, addFoundation, addEyeshadow, addBlush);
        priceMessage += "\nThanks for your order!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}
