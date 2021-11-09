package com.example.predicttemperaturewithcricketchirp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/*did you know you can determine the temperature outside by counting the number of chips that your
kid makes. Just count the number of chips one makes in twenty five seconds and calculate
to get to predict temperature*/
public class MainActivity extends AppCompatActivity {

    EditText etChirp;
    Button btnCalculate;
    TextView tvResult;

//    to define a decimal format.
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirp = findViewById(R.id.etChirp);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

//        #0.00 which will mean basically it's going to give it to us as two decimal places.
        formatter = new DecimalFormat("#0.00");

        tvResult.setVisibility(View.GONE);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etChirp.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }else{
                    int numberChirps = Integer.parseInt(etChirp.getText().toString().trim());

                    /*the reason why put a 3.0 a day is because this is an integer and if both sides of the division operate
                    * If you want to have it as a double so I divide by 3.0 not just three.*/
                    double temp = (numberChirps/3.0)+4;

                    String result = "The approximate temperature outside is " + formatter.format(temp) + " degrees Celisus.";

                    tvResult.setText(result);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}