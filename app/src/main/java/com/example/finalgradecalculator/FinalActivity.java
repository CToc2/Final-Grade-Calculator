package com.example.finalgradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {

    private TextView finalText;
    private TextView equation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        finalText = findViewById(R.id.finalText);
        equation = findViewById(R.id.equation);


        calculate();
    }

    public void calculate() {
        SharedPreferences sp = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
        double grade = sp.getInt("current", 60);
        double weight = sp.getInt("weight", 30);
        double desired = sp.getInt("final", 70);
//        grade = Math.round(grade*100)/100;
        equation.setText(desired+ " - ((1 - "+weight/100+") * "+grade+")/ "+ weight/100);
        if (grade > 100){
            Toast.makeText(this, "Current grade not valid", Toast.LENGTH_LONG).show();
        }
        else{
//            double weight = sp.getInt("weight", 30);
            if (weight <= 100 && weight > 0){
//                double desired = sp.getInt("final", 70);
                weight = weight/100;
                double num = desired - ((1 - weight) * grade);
                num /= weight;
                if (num >= 0){
                    finalText.setText("Total: "+String.format("%.2f",num)+"%");
                }
                else{
                    Toast.makeText(this, "Desired Grade is not possible", Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(this, "Grade weight not valid", Toast.LENGTH_LONG).show();
            }

        }

        }
    }

