package com.example.rodolfo.mcda5550;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Context;
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

        EditText height = findViewById(R.id.Height);
        String value = height.getText().toString();
        Double heightval = Double.parseDouble(value);
        System.out.println("Here is the height" + heightval);

        EditText weight = findViewById(R.id.Weight);
        String value2 = weight.getText().toString();
        Double weightval = Double.parseDouble(value2);
        System.out.println("Here is the weight" + weightval);

        // Weight
        Double calc = (weightval / (heightval * heightval));

        // Have to save the data into the table Measures
        SaveBMI();




        EditText result = findViewById(R.id.Result);
        result.setText(DForm.format(calc));



    }

    public void SaveBMI()
    {
        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();




        Bundle b = getIntent().getExtras();
        String UsrEmail = b.getString("email");

       // EditText heightComp = (EditText) findViewById(R.id.Height);
       // heightComp.setText(UsrEmail);
        //Bundle b = new Bundle();

        EditText WeightVal = findViewById(R.id.Weight);
        Double Wval = Double.parseDouble(WeightVal.getText().toString());

        EditText HeightVal = findViewById(R.id.Height);
        Double Hval = Double.parseDouble(HeightVal.getText().toString());

        helper.InsertNewBMI(db,UsrEmail,Wval,Hval);



    }
}
