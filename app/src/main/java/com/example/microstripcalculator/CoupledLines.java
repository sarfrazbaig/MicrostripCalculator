package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CoupledLines extends AppCompatActivity {

    String w,s,zc,ere,h;
    EditText w_et,s_et,zc_et,ere_et,h_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupled_lines);
        Intent coupled_intent = getIntent();
    }

    public void coupledLinesCalc(View view){

        w_et = (EditText)findViewById(R.id.editText2);
        s_et = (EditText)findViewById(R.id.editText);
        zc_et = (EditText)findViewById(R.id.editText3);
        ere_et = (EditText)findViewById(R.id.editText7);
        h_et = (EditText)findViewById(R.id.editTextHeight);

        w = w_et.getText().toString();
        s = s_et.getText().toString();
        zc = zc_et.getText().toString();
        ere = ere_et.getText().toString();
        h = h_et.getText().toString();

        Intent coupled_lines_calc = new Intent(this,CoupledLinesCalc.class);
        coupled_lines_calc.putExtra("width",w);
        coupled_lines_calc.putExtra("separation",s);
        coupled_lines_calc.putExtra("impedance",zc);
        coupled_lines_calc.putExtra("dielectric",ere);
        coupled_lines_calc.putExtra("height",h);

        startActivity(coupled_lines_calc);
    }
}
