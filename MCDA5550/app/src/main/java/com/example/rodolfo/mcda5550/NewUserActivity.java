package com.example.rodolfo.mcda5550;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class NewUserActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);





    }


    public void onClickList(View view)
    {
        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        EditText nName   = (EditText)findViewById(R.id.Name);
        EditText nPass   = (EditText)findViewById(R.id.Password);
        EditText nHealth   = (EditText)findViewById(R.id.HealthCard);
        EditText nEmail   = (EditText)findViewById(R.id.Email);

        helper.InsertNewUsr(db,nName.getText().toString(),nPass.getText().toString(),nHealth.getText().toString(),nEmail.getText().toString());
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}

