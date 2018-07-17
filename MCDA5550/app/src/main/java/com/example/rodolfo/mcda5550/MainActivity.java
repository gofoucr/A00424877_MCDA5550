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

        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME,new String[]{"NAME","PASSWORD","DATE"},
                null,null,null,null,null);



        if (cursor.moveToFirst())
        {
            String name = cursor.getString(0);
            String passwd = cursor.getString(1);

            EditText results = (EditText) findViewById(R.id.Name);
            results.setText(name);

            EditText rpass = (EditText) findViewById(R.id.Password);
            rpass.setText(passwd);
        }

        cursor.close();
        db.close();

    }

    public void onClickEnter(View view){
        Intent intent = new Intent( this,activity_calculate_bmi.class);
        startActivity(intent);
    }
}

