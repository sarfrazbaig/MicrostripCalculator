package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CoupledLinesCalc extends AppCompatActivity {

    Double w,s,zc,ere,h;
    Double ce,co,cp,cf,cfdash,cgd,cga,e0,a,kfunc,k,kdash,zce,zco,eree,ereo;
    EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupled_lines_calc);

        Intent values = getIntent();
        w = Double.valueOf(values.getExtras().getString("width"));
        s = Double.valueOf(values.getExtras().getString("separation"));
        zc = Double.valueOf(values.getExtras().getString("impedance"));
        ere = Double.valueOf(values.getExtras().getString("dielectric"));
        h = Double.valueOf(values.getExtras().getString("height"));

        e0 = 0.00000000000885;
        cp = (e0*ere*w)/h;
        cf = (((Math.sqrt(ere))/(300000000*zc)) - cp)/2;
        a = Math.exp(-0.1*(Math.exp(2.33-(2.53*(w/h)))));
        cfdash = cf/(1+a*(h/s)*Math.tanh(8*s/h));

        cgd = ((e0*ere)/Math.PI)*Math.log(1/(Math.tanh((Math.PI/4)*(s/h)))) + 0.65*cf*(((0.02*Math.sqrt(ere))/(s/h)))+1-(1/(ere*ere));
        k = (s/h)/((s/h)+2*(w/h));
        kdash = Math.sqrt(1-(k*k));
        if(k*k<=0.5 && k*k>=0){
            kfunc = (1/Math.PI) * Math.log(2*(1+Math.sqrt(kdash))/(1-Math.sqrt(kdash)));
        }
        else if(k*k<=1 && k*k>=0.5){
            kfunc = (Math.PI)/Math.log(2*(1+Math.sqrt(k))/(1-Math.sqrt(k)));
        }

        cga = e0 * kfunc;
        ce = cp + cf + cfdash;
        co = cp + cf + cgd + cga;

        zce = 1/(300000000*Math.sqrt((ce*ce)/ere));
        zco = 1/(300000000*Math.sqrt((co*co)/ere));

        eree = ce/(ce/ere);
        ereo = co/(co/ere);

        e1 = (EditText)findViewById(R.id.editText15);
        e2 = (EditText)findViewById(R.id.editText16);
        e3 = (EditText)findViewById(R.id.editText17);
        e4 = (EditText)findViewById(R.id.editText18);

        e1.setText(Double.toString(zce));
        e2.setText(Double.toString(zco));
        e3.setText(Double.toString(eree));
        e4.setText(Double.toString(ereo));
    }

    public void back_home_main(View view){
        Intent main_activity = new Intent(this,MainScreen.class);

        startActivity(main_activity);
    }
}
