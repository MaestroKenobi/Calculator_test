package com.saranthyrprod.calculator_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText eNT = findViewById(R.id.editTextNumber);
        Button b = (Button) view;
        eNT.setText(eNT.getText().toString() + b.getText().toString());
    }

    public void onClick2(View view) {
        EditText eNT = findViewById(R.id.editTextNumber);
        Button b = (Button) view;
        if (eNT.getText().toString().endsWith("/") || eNT.getText().toString().endsWith("+") || eNT.getText().toString().endsWith("-") || eNT.getText().toString().endsWith("*")) {
            eNT.setText(eNT.getText().toString().replaceAll(".$", ""));
            eNT.setText(eNT.getText().toString() + b.getText().toString());
        }
        else {
            eNT.setText(eNT.getText().toString() + b.getText().toString());
        }
    }

    public void Result(View view) {
        EditText eNT = findViewById(R.id.editTextNumber);
        String expression = eNT.getText().toString();
        if (expression.contains("+")) {
            String[] temp = expression.split("\\+");
            float a = Float.parseFloat(temp[0]);
            float b = Float.parseFloat(temp[1]);
            float result = a+b;
            eNT.setText(Float.toString(result));
        }
        else if (expression.contains("-")) {
            String[] temp = expression.split("-");
            float a = Float.parseFloat(temp[0]);
            float b = Float.parseFloat(temp[1]);
            float result = a-b;
            eNT.setText(Float.toString(result));
        }
        else if (expression.contains("*")) {
            String[] temp = expression.split("\\*");
            float a = Float.parseFloat(temp[0]);
            float b = Float.parseFloat(temp[1]);
            float result = a*b;
            eNT.setText(Float.toString(result));
        }
        else if (expression.contains("/")) {
            String[] temp = expression.split("/");
            float a = Float.parseFloat(temp[0]);
            float b = Float.parseFloat(temp[1]);
            float result = a/b;
            eNT.setText(Float.toString(result));
        }
        if (eNT.getText().toString().endsWith(".0")) {
            String[] temp1 = eNT.getText().toString().split("\\.");
            eNT.setText(temp1[0]);
        }

    }

    public void removeLast(View view) {
        EditText eNT = findViewById(R.id.editTextNumber);
        eNT.setText(eNT.getText().toString().replaceAll(".$", ""));
    }

    public void Clear(View view) {
        EditText eNT = findViewById(R.id.editTextNumber);
        eNT.setText("");
    }
}