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
        //get the inputs from one and two then make them numbers
        EditText input1E = findViewById(R.id.input_text_box1);
        String input1S = input1E.toString();
        EditText input2E = findViewById(R.id.input_text_box2);
        String input2S = input2E.toString();

        double input1 = Double.parseDouble(input1S);
        double input2 = Double.parseDouble(input2S);

        String selection = findViewById(R.id.operation_selection_dropdown);
        double ans;



        //on change
        if(selection == "Addition"){
            ans = input1 + input2;
        }
        if(selection == "Subtraction"){
            ans = input1 - input2;
        }
        if(selection == "Multiplication"){
            ans = input1 * input2;
        }
        if(selection == "Division"){
            ans = input1 / input2;
        }
        if(selection == "Integer Division"){
            ans = (int)(input1 / input2);
        }
        if(selection == "Mod"){
            ans = input1 % input2;
        }

        //textView.set(result)
    }
}