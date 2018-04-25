package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }


    public void analysis(View view) {
        Intent synthesis_calculation = new Intent(this,MainActivity.class);
        startActivity(synthesis_calculation);
    }

    public void coupledLines(View view){
        Intent coupledLinesCalculation = new Intent(this,CoupledLines.class);
        startActivity(coupledLinesCalculation);
    }
}
