package com.example.finalgradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    private EditText currentGrade;
    private EditText gradeWeight;
    private RadioGroup radioGroup;
    private RadioButton radio60;
    private RadioButton radio70;
    private RadioButton radio80;
    private RadioButton radio90;
    private RadioButton radio100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGroup();
        initCalculateButton();
        initSettings();

    }

    private void initCalculateButton(){
        Button calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = Integer.parseInt(currentGrade.getText().toString());
                int weight = Integer.parseInt((gradeWeight.getText().toString()));

                SharedPreferences sp = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("current", current);
                editor.putInt("weight", weight);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void initSettings() {
        SharedPreferences sharedPref = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
        int gradeChoice = sharedPref.getInt("grade", 60);
        if (gradeChoice == 60) {
            radio60.setChecked(true);
        } else if (gradeChoice == 70) {
            radio70.setChecked(true);
        } else if (gradeChoice == 80) {
            radio80.setChecked(true);
        } else if (gradeChoice == 90) {
            radio90.setChecked(true);
        } else {
            radio100.setChecked(true);
        }
    }


    private void initGroup(){
        currentGrade = findViewById(R.id.currentGrade);
        gradeWeight = findViewById(R.id.gradeWeight);

        radioGroup = findViewById(R.id.radioGroup);
        radio60 = findViewById(R.id.radio60);
        radio70 = findViewById(R.id.radio70);
        radio80 = findViewById(R.id.radio80);
        radio90 = findViewById(R.id.radio90);
        radio100 = findViewById(R.id.radio100);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radio60.isChecked()){
                    SharedPreferences sp = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("final", 60);
                    editor.apply();
                }else if (radio70.isChecked()){
                    SharedPreferences sp = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("final", 70);
                    editor.apply();
                }else if (radio80.isChecked()){
                    SharedPreferences sp = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("final", 80);
                    editor.apply();
                }else if (radio90.isChecked()){
                    SharedPreferences sp = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("final", 90);
                    editor.apply();
                }else{
                    SharedPreferences sp = getSharedPreferences("FinalGradePreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("final", 100);
                    editor.apply();
                }
            }
        });
    }
    public void onResume(){
        super.onResume();
    }

}