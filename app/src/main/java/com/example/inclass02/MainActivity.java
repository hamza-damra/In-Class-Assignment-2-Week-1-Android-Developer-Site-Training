package com.example.inclass02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_value, tv_amount;
    EditText et_amount;
    AppCompatButton btn_dis_5, btn_dis_10, btn_dis_15, btn_dis_20, btn_dis_50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_value = findViewById(R.id.tv_discounted_value);
        tv_amount = findViewById(R.id.tv_discounted_price);
        et_amount = findViewById(R.id.et_ticket_price);
        btn_dis_5 = findViewById(R.id.btn_discount_5);
        btn_dis_10 = findViewById(R.id.btn_discount_10);
        btn_dis_15 = findViewById(R.id.btn_discount_15);
        btn_dis_20 = findViewById(R.id.btn_discount_20);
        btn_dis_50 = findViewById(R.id.btn_discount_50);
        btn_dis_5.setOnClickListener(this);
        btn_dis_10.setOnClickListener(this);
        btn_dis_15.setOnClickListener(this);
        btn_dis_20.setOnClickListener(this);
        btn_dis_50.setOnClickListener(this);



    }


    static String calculateDiscountedPrice(float price, int discountValue)
    {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        float value = price * discountValue * 0.01f;
        price = price - value;
        return decimalFormat.format(price);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        AppCompatButton Button = (AppCompatButton) view;
        String et_value = et_amount.getText().toString();
        if (et_value.isEmpty())
        {
            Toast.makeText(getBaseContext(),"Please Enter A Value",Toast.LENGTH_SHORT).show();
        }else
        {
            float value = Float.parseFloat(et_value);
            if(Button.getId() == R.id.btn_discount_5)
            {
                tv_value.setText("5%");
                tv_amount.setText(calculateDiscountedPrice(value,5));
            }else if(Button.getId() == R.id.btn_discount_10)
            {
                tv_value.setText("10%");
                tv_amount.setText(calculateDiscountedPrice(value,10));
            }else if(Button.getId() == R.id.btn_discount_15)
            {
                tv_value.setText("15%");
                tv_amount.setText(calculateDiscountedPrice(value,15));
            }else if(Button.getId() == R.id.btn_discount_20)
            {
                tv_value.setText("20%");
                tv_amount.setText(calculateDiscountedPrice(value,20));
            }else if(Button.getId() == R.id.btn_discount_50)
            {
                tv_value.setText("50%");
                tv_amount.setText(calculateDiscountedPrice(value,50));
            }else
            {
                tv_value.setText("");
                tv_amount.setText("");
            }
        }

    }
}