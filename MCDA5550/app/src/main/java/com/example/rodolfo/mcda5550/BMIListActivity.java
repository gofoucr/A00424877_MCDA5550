package com.example.rodolfo.mcda5550;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BMIListActivity extends ListActivity {


    //BMIResult[] results;//{new BMIResult(5.5,100),new BMIResult(4.3,156)};
    ArrayList<BMIResult> results = new ArrayList<BMIResult>();
    //Array[] results = new BMIResult[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bmilist);
        getBMI();
        ListView listBMIResults = getListView();
        ArrayAdapter<BMIResult> listAdapter = new ArrayAdapter<BMIResult>(
                this,
                android.R.layout.simple_list_item_1,
                results);
        listBMIResults.setAdapter(listAdapter);
    }

    public void getBMI()
    {
        Integer idx = 0;
        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Bundle b = getIntent().getExtras();
        String UsrEmail = b.getString("email");
        //EditText remail = findViewById(R.id.Email);
        //remail.setText(UsrEmail);


        //Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME2,null,//new String[]{"HEIGHT","WEIGHT"},
        //        null,null,null,null,null);

        Cursor cursor = helper.GetAllBMI(db,UsrEmail);


            while (cursor.moveToNext()) {

                //if (cursor.moveToFirst()) {
                    Double usrHei = cursor.getDouble(0);
                    Double usrWei = cursor.getDouble(1);
                    results.add(new BMIResult(usrHei, usrWei));


            }

        cursor.close();
        db.close();

    }


    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id)
    {
        System.out.println("Clicked on " );
    }

}
