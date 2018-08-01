package com.example.rodolfo.mcda5550;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        String UsrEmail = b.getString("email");
        EditText heightComp = findViewById(R.id.Email);
        heightComp.setText(UsrEmail);

        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME,new String[]{"NAME","PASSWORD","DATE","EMAIL","HEALTH_CARD_NUMB"},
                null,null,null,null,null);



        if (cursor.moveToFirst())
        {
            String name   = cursor.getString(0);
            String passwd = cursor.getString(1);
            String date   = cursor.getString(2);
            String email  = cursor.getString(3);
            String health = cursor.getString(4);

            EditText results = findViewById(R.id.Name);
            results.setText(name);

            EditText rpass = findViewById(R.id.Password);
            rpass.setText(passwd);

            EditText rbirth = findViewById(R.id.BirthDay);
            rbirth.setText(date);

            EditText remail = findViewById(R.id.Email);
            remail.setText(email);

            EditText rhealth = findViewById(R.id.HealthCard);
            rhealth.setText(health);




        }

        cursor.close();
        db.close();

    }

    public void onClickEnter(View view){
        Intent intent = new Intent( this,activity_calculate_bmi.class);
        String newM = new String();
        EditText EmialComp = findViewById(R.id.Email);

        newM = EmialComp.getText().toString();
        Bundle b = new Bundle();
        b.putString("email",newM);

        intent.putExtras(b);

        startActivity(intent);
    }

    public void onClickList(View view)
    {
        Intent intent = new Intent(this,BMIListActivity.class);
        EditText EmailC = findViewById(R.id.Email);

        String Usr = EmailC.getText().toString();
        Bundle b = new Bundle();
        b.putString("email",Usr);
        intent.putExtras(b);

        startActivity(intent);

    }
}

