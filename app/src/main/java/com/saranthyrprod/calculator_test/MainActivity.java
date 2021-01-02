package com.saranthyrprod.calculator_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
        ArrayList<Float> subtest = new ArrayList<>();
        float result = 0;
        String[] temp = expression.split("\\+|\\*|/|-");
        String[] temp1 = expression.split("[0-9]|\\.");
        ArrayList<String> tmp1 = new ArrayList<>();
        ArrayList<String> tmp2 = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            test.add(Float.parseFloat(temp[i]));
        }
        for (int i = 0; i < temp1.length; i++) {
            tmp1.add(temp1[i]);
        }
        for (int i = 0; i < tmp1.size()-1; i++) {
            System.out.println(tmp1.get(i));
            if (tmp1.get(i) == "*" | tmp1.get(i) == "/") {
                if (tmp1.get(i) == "*") {
                    float tmp = test.get(i) * test.get(i + 1);
                    subtest.add(tmp);
                }
                if (tmp1.get(i) == "/") {
                    float tmp = test.get(i) / test.get(i + 1);
                    subtest.add(tmp);
                }
            }
            else {
                subtest.add(test.get(i));
                tmp2.add(temp1[i]);
            }
        }

        for (int i = 0; i < tmp2.size()-1; i++) {
            System.out.println(tmp1.get(i));
            if (tmp2.get(i) == "+" | tmp2.get(i) == "-") {
                if (tmp2.get(i) == "+") {
                    float tmp = subtest.get(i) + subtest.get(i+1);
                    result = result + tmp;
                }
                if (tmp2.get(i) == "-") {
                    float tmp = subtest.get(i) - subtest.get(i+1);
                    result = result + tmp;
                }
            }
            eNT.setText(Float.toString(result));
        }

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
            String[] temp2 = eNT.getText().toString().split("\\.");
            eNT.setText(temp2[0]);
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