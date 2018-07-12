package com.example.rodolfo.mcda5550;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

import javax.xml.transform.Result;

public class activity_calculate_bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
    }

    public void Calculate(View view)
    {
        DecimalFormat DForm = new DecimalFormat("0.##");

        EditText height = (EditText) findViewById(R.id.Height);
        String value = height.getText().toString();
        Double heightval = Double.parseDouble(value);
        System.out.println("Here is the height" + heightval);

        EditText weight = (EditText) findViewById(R.id.Weight);
        String value2 = weight.getText().toString();
        Double weightval = Double.parseDouble(value2);
        System.out.println("Here is the weight" + weightval);

        // Weight
        Double calc = (weightval / (heightval * heightval));



        EditText result = (EditText) findViewById(R.id.Result);


        result.setText(DForm.format(calc));



    }
}
