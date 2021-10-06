package com.example.ordercoffeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void decrement(View view){
        quantity = quantity - 1;
        if (quantity<0){
            Toast.makeText(getApplicationContext(),"Cannot be negative number",Toast.LENGTH_SHORT).show();
        }
        else{
            display_quantity(quantity);
        }
    }
    public void increment(View view){
        quantity = quantity + 1;
        if (quantity>10){
            Toast.makeText(getApplicationContext(),"Cannot be more than 10",Toast.LENGTH_SHORT).show();
        }
        else{
            display_quantity(quantity);
        }
    }

    private void display_quantity(int quantity) {
        TextView quantity1= (TextView) findViewById(R.id.amount_qty);
        quantity1.setText(""+ quantity);
    }
    private void displayMessage(String finalMessage) {
        TextView Message = (TextView) findViewById(R.id.final_message);
        Message.setText(""+ finalMessage);
    }

    private String createMessage(String names, Boolean chocolates, Boolean whipped_creams, int price) {
        String Message = "Name: " + names + "\n" + "Chocolate Ordered: " + chocolates + "\n" +"Whipped Cream Ordered: " + whipped_creams +"\n" + "Total Price: " + price;
        return Message;
    }

    private int calculatePrice(Boolean chocolates, Boolean whipped_creams) {
        int price = 5;
        if(chocolates){
            price = price +2;
        }
        if(whipped_creams){
            price = price + 1;
        }
        return quantity*price;
    }

    public void OrderButton(View view) {

        EditText name =(EditText) findViewById(R.id.Name_Input);
        String names = name.getText().toString();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        Boolean chocolates =chocolate.isChecked();
        CheckBox whipped_cream = (CheckBox) findViewById(R.id.whipped_cream);
        Boolean whipped_creams =whipped_cream.isChecked();
        int price = calculatePrice(chocolates,whipped_creams);
        String finalMessage = createMessage (names,chocolates,whipped_creams, price);
        displayMessage(finalMessage);


        
    }


}