package com.example.calculatorapphussain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void compute(View v){
        //get the inputs from one and two then make them numbers
        EditText input1E = findViewById(R.id.input_text_box1);
        String input1S = input1E.getText().toString();
        EditText input2E = findViewById(R.id.input_text_box2);
        String input2S = input2E.getText().toString();

        Log.i("input1", input1S);
        Log.i("input2", input2S);
        double input1 = Double.parseDouble(input1S);
        double input2 = Double.parseDouble(input2S);

        Spinner selectionSpin = findViewById(R.id.operation_selection_dropdown);
        String selection = selectionSpin.getSelectedItem().toString();
        double ans = 0;

        //show equation
        TextView equationTV = findViewById(R.id.equation_textView);
        String equationString = input1S + " ";
        equationTV.setText(equationString);

        //math
        if(selection.equals("Addition")){
            ans = input1 + input2;
            String ansS = ans + "";
            equationString += "+";
            equationTV.setText(equationString);
            Log.i("input4", ansS);
        }
        if(selection.equals("Subtraction")){
            ans = input1 - input2;
            equationString += "-";
            equationTV.setText(equationString);
        }
        if(selection.equals("Multiplication")){
            ans = input1 * input2;
            equationString += "x";
            equationTV.setText(equationString);
        }
        if(selection.equals("Division")){
            ans = input1 / input2;
            equationString += "/";
            equationTV.setText(equationString);
        }
        if(selection.equals("Mod")){
            ans = input1 % input2;
            equationString += "%";
            equationTV.setText(equationString);
        }

        //textView.set(result)
        String ansS = ans + "";
        Log.i("input3", ansS);

        equationString += " " + input2S + " = ";
        equationTV.setText(equationString);

        TextView resultTV = findViewById(R.id.result_textView);
        resultTV.setText(ansS);
    }
}