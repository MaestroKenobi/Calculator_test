package com.saranthyrprod.calculator_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int a = eNT.getText().toString().length();
        if (eNT.getText().toString().endsWith("/") || eNT.getText().toString().endsWith("+") || eNT.getText().toString().endsWith("-") || eNT.getText().toString().endsWith("*")) {
            if (a == 1 & eNT.getText().toString().startsWith("-")) {
                eNT.setText(eNT.getText().toString() + b.getText().toString());
            }
            else {
                eNT.setText(eNT.getText().toString().replaceAll(".$", ""));
                eNT.setText(eNT.getText().toString() + b.getText().toString());
            }
        }
        else {
            eNT.setText(eNT.getText().toString() + b.getText().toString());
        }
    }

    public void Result(View view) {
        EditText eNT = findViewById(R.id.editTextNumber);
        String expression = eNT.getText().toString();
        ArrayList<Float> test = new ArrayList<>();
        float result = 0;
        String[] temp = expression.split("\\+|\\*|/|-");
        String temp2 = expression.replaceAll("[0-9]|\\.", "");
        char[] tmp1 = temp2.toCharArray();
        List<Character> actions = new ArrayList<>();
        for (char c : tmp1) {
            actions.add(c);
        }
        int j = actions.size();
        while (actions.isEmpty() == false && test.size() > 1) {
            for (int i = 0; i < j; ) {
                if (actions.get(i) == '*') {
                    float tmp = test.get(i) * test.get(i + 1);
                    test.set(i, tmp);
                    test.remove(i + 1);
                    actions.remove(i);
                    i = i;
                } else if (actions.get(i) == '/') {
                    float tmp = test.get(i) / test.get(i + 1);
                    test.set(i, tmp);
                    test.remove(i + 1);
                    actions.remove(i);
                    i = i;
                } else {
                    i++;
                }
            }
            for (int i = 0; i < j;)  {
                if (actions.get(i) == '+') {
                    float tmp = test.get(i) + test.get(i + 1);
                    test.set(i, tmp);
                    test.remove(i + 1);
                    actions.remove(i);
                    i = i;
                } else if (actions.get(i) == '-') {
                    float tmp = test.get(i) - test.get(i + 1);
                    test.set(i, tmp);
                    test.remove(i + 1);
                    actions.remove(i);
                    i = i;
                } else {
                    i++;
                }
            }
        }
        result = test.get(0);
        eNT.setText(Float.toString(result));
//        if (expression.contains("+")) {
//            String[] temp = expression.split("\\+");
//            int tempL = temp.length;
//            for (int i = 0; i < tempL; i++) {
//                test.add(Float.parseFloat(temp[i]));
//            }
//            for (int i = 0; i < test.size(); i++) {
//                result = result + test.get(i);
//            }
//            eNT.setText(Float.toString(result));
//        }
//        else if (expression.contains("-")) {
//            String[] temp = expression.split("-");
//            int tempL = temp.length;
//            for (int i = 0; i < tempL; i++) {
//                test.add(Float.parseFloat(temp[i]));
//            }
//            result = result + test.get(0);
//            for (int i = 1; i < test.size(); i++) {
//                result = result - test.get(i);
//            }
//            eNT.setText(Float.toString(result));
//        }
//        else if (expression.contains("*")) {
//            String[] temp = expression.split("\\*");
//            int tempL = temp.length;
//            for (int i = 0; i < tempL; i++) {
//                test.add(Float.parseFloat(temp[i]));
//            }
//            for (int i = 0; i < test.size(); i++) {
//                result = result * test.get(i);
//            }
//            eNT.setText(Float.toString(result));
//        }
//        else if (expression.contains("/")) {
//            String[] temp = expression.split("/");
//            int tempL = temp.length;
//            for (int i = 0; i < tempL; i++) {
//                test.add(Float.parseFloat(temp[i]));
//            }
//            for (int i = 0; i < test.size(); i++) {
//                result = result / test.get(i);
//            }
//            eNT.setText(Float.toString(result));
//        }
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