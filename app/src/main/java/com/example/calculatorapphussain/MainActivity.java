package com.example.calculatorapphussain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spin;
    int index;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainLayout);

        spin = findViewById(R.id.operation_selection_dropdown);
        String[] operations =getResources().getStringArray(R.array.operations);

        spin.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, operations);

        spin.setAdapter(adapter);
    }

    @SuppressLint("SetTextI18n")
    public void clearAll(View v){
        //clear equation box
        TextView eqnBox = findViewById(R.id.equation_textView);
        eqnBox.setText("________________");
        //clear answer box
        TextView ansBox = findViewById(R.id.result_textView);
        ansBox.setText("________________");

        //clear inputs 1 and 2
        EditText input1 = findViewById(R.id.input_text_box1);
        EditText input2 = findViewById(R.id.input_text_box2);
        input1.setText("");
        input2.setText("");
    }

    public void clearInputs(View v){
        //clear inputs 1 and 2
        EditText input1 = findViewById(R.id.input_text_box1);
        EditText input2 = findViewById(R.id.input_text_box2);
        input1.setText("");
        input2.setText("");
    }

    public void compute(){
        //get the inputs from one and two then make them numbers
        EditText input1E = findViewById(R.id.input_text_box1);
        String input1S = input1E.getText().toString();
        EditText input2E = findViewById(R.id.input_text_box2);
        String input2S = input2E.getText().toString();

        Log.i("input1", input1S);
        Log.i("input2", input2S);
        double input1;
        double input2;

        if(input1S.equals("") || input2S.equals("")){
            //snackbar error msg
            Log.i("farjad", "empty inputs");
            Snackbar.make(mainLayout, "input valid numbers", Snackbar.LENGTH_SHORT).show();
        }
        else{
            input1 = Double.parseDouble(input1S);
            input2 = Double.parseDouble(input2S);
            Log.i("farjad", input1+ " " + input2);
            //operation
            Spinner spin = findViewById(R.id.operation_selection_dropdown);
            String selection = spin.getSelectedItem().toString();
            Log.i("farjad", selection);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        index=i;
        if(i != 0){
            compute();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //add a snackbar error msg
    }
}