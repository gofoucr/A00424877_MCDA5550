package com.example.rodolfo.mcda5550;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.IntegerRes;

import org.w3c.dom.Text;

import java.util.Date;

import static android.icu.lang.UProperty.NAME;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class InClassDatabaseHelper extends SQLiteOpenHelper {

    private static Context context;
    private static final String DB_NAME = "Project";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "PERSON";
    public static final String TABLE_NAME2 = "BODYMASS";
    public InClassDatabaseHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }

   // @Override
   // public void onCreate(SQLiteDatabase db){

    //}

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("
        +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
        +"NAME STRING,"
                +"EMAIL STRING,"
        +"PASSWORD STRING,"
        +"HEALTH_CARD_NUMB STRING,"
        +"DATE INTEGER);");

        Date today = new Date();
        ContentValues personValues = new ContentValues();
        personValues.put("NAME","Rodolfo Garcia");
        personValues.put("EMAIL","rgb@mcda550.com");
        personValues.put("PASSWORD","Super");
        personValues.put("HEALTH_CARD_NUMB","1234 5678 9101");
        personValues.put("DATE",today.getTime());

        db.execSQL("CREATE TABLE "+TABLE_NAME2+" ("
                +"EMAIL STRING,"
                +"HEIGHT DOUBLE,"
                +"WEIGHT DOUBLE,"
                +"DATE INTEGER);");

        db.insert(TABLE_NAME,null,personValues);
    }

    public void InsertNewBMI(SQLiteDatabase db,String IDusr, Integer NewHei, Integer NewWei)
    {
        //SQLiteDatabase db;
        //db = new SQLiteDatabase();
        Date today = new Date();
        ContentValues BMIValues = new ContentValues();
        BMIValues.put("EMAIL",IDusr);
        BMIValues.put("HEIGHT",NewHei.doubleValue());
        BMIValues.put("WEIGHT",NewWei.doubleValue());
        BMIValues.put("DATE",today.getTime());

        db.insert(TABLE_NAME2,null,BMIValues);
    }

    public void InsertNewUsr(SQLiteDatabase db, String vNAme, String vPass, String vHealth, String vEmail)
    {

        Date today = new Date();
        ContentValues personValues = new ContentValues();
        personValues.put("NAME",vNAme);
        personValues.put("PASSWORD",vPass);
        personValues.put("HEALTH_CARD_NUMB",vHealth);
        personValues.put("EMAIL",vEmail);
        personValues.put("DATE",today.getTime());

        db.insert(TABLE_NAME,null,personValues);
    }

    public boolean ValidateUser(SQLiteDatabase db,String vEmail,String Passwd)
    {

        //boolean find = new boolean;

        String query = "Select NAME from PERSON where EMAIL = " +"'" + vEmail.toString()+"'" + " and PASSWORD = "+"'"+Passwd.toString()+"'";

        Cursor cursor = db.rawQuery(query,null);

        //(InClassDatabaseHelper.TABLE_NAME,new String[]{"NAME"},"Select NAME from " + TABLE_NAME +
          //              "where EMAIL = " + vEmail + " and PASSWORD = "+Passwd+")");
        if (cursor.getCount() > 0)
        {
            return TRUE;
        }
        else
        {
            return FALSE;

        }


    }

    public Cursor GetAllBMI(SQLiteDatabase db,String vEmail)
    {
        String[] tableColumns = new String[] {
                "HEIGHT",
                "WEIGHT"
        };
        String whereClause = "EMAIL ="+ "'"+vEmail+"'";
        //String[] whereArgs = new String[]{};
        //whereArgs[1] = vEmail.toString();


        //String query = "Select HEIGHT,WEIGHT from BODYMASS where EMAIL = " +"'" + vEmail+"'";

        Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME2,new String[]{"HEIGHT","WEIGHT"},
                null,null,null,null,null);

       return cursor;
    }

}
