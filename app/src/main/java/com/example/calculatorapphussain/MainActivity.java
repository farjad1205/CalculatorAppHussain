package com.example.calculatorapphussain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void compute(View v){
        //on CLick
        if(spinnerSelect == ){
            result = input1 + input2;
        }

        //textView.set(result)
    }

    public void switchScreens(View v) {
        Intent intent = new Intent(this, ButtonMode.class);
        startActivity(intent);
    }
}