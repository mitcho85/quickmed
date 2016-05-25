package com.example.jarnin.quickmed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

/**
 * Created by jarnin on 5/20/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "patientInfo";

    //Patients table name
    private static final String TABLE_PATIENTS = "patients";

    //Patients table column names
    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "NAME";
    private static final String KEY_BIRTHDAY = "BIRTHDAY";
    private static final String KEY_WEIGHT = "WEIGHT";
    private static final String KEY_HEIGHT = "HEIGHT";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PATIENTS +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, BIRTHDAY STRING, WEIGHT INTEGER, HEIGHT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENTS);
        onCreate(db);
    }

    public boolean insertNewPatient() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, "");
        contentValues.put(KEY_BIRTHDAY, "0/00/0000");     //default value
        contentValues.put(KEY_HEIGHT, -1);
        contentValues.put(KEY_WEIGHT, -1);
        long result = db.insert(TABLE_PATIENTS, null, contentValues);
        Log.d("DBHelper.java", "insertNewPatient: result = " + result);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getPatient(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] selectionArgs = {name};
        Cursor cursor = db.query(TABLE_PATIENTS, null, "NAME = ?", selectionArgs, null, null, null);
        return cursor;
    }

    public Cursor getAllPatients() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PATIENTS + ";", null);
        return cursor;
    }
}
