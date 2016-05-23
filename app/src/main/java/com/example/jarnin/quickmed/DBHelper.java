package com.example.jarnin.quickmed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    private static final String KEY_AGE = "AGE";
    private static final String KEY_WEIGHT = "WEIGHT";
    private static final String KEY_HEIGHT = "HEIGHT";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_PATIENTS +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AGE INTEGER, WEIGHT INTEGER, HEIGHT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENTS);
        onCreate(db);
    }
}
