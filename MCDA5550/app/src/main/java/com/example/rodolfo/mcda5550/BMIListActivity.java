package com.example.rodolfo.mcda5550;

import android.app.ListActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BMIListActivity extends ListActivity {

    BMIResult[] results = {new BMIResult(5.5,100),new BMIResult(4.3,156)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bmilist);

        ListView listBMIResults = getListView();
        ArrayAdapter<BMIResult> listAdapter = new ArrayAdapter<BMIResult>(
                this,
                android.R.layout.simple_list_item_1,
                results);
        listBMIResults.setAdapter(listAdapter);
    }



    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id)
    {
        System.out.println("Clicked on " + results[position].toString());
    }

}
