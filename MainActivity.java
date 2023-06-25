package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.bmicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt_res;
        EditText edt_wt, edt_htF, edt_htI;
        Button btn_calc;

        edt_wt = findViewById(R.id.edt_wt);
        edt_htF = findViewById(R.id.edt_htF);
        edt_htI = findViewById(R.id.edt_htI);
        txt_res = findViewById(R.id.txt_res);
        btn_calc = findViewById(R.id.btn_calc);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt =  Integer.parseInt(edt_wt.getText().toString());
               int ft = Integer.parseInt(edt_htF.getText().toString());
               int in = Integer.parseInt(edt_htI.getText().toString());
               double ttlIn = ft*12 + in;
               double ttlCm = ttlIn *2.53;
               double ttlM = ttlCm/100;
               double bmi = wt/(ttlM*ttlM);

               if (bmi>25)
               {
                   txt_res.setText("Yor are Overweight");
               } else if (bmi<25)
               {
                   txt_res.setText("Your are Underweight");
               }
               else if (bmi==25)
               {
                   txt_res.setText("You are Healthy");
               }

            }
        });


    }
}