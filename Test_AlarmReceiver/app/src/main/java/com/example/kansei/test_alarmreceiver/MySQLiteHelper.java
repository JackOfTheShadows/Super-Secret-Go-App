package com.example.kansei.test_alarmreceiver;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kansei on 05.07.16.
 */
public class MySQLiteHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "MeetingStarts.db";
    private static final int DATABASE_VERSION = 1;


    /* Datenbank erstellt mit den namen MEETINGS
    ID als primary key autoincrement
    gespeichert werten in den Db MEETING_ID, TIMESTAMP
     */

    private static final String TABLE_CREATE_VERLAUF = ""
            + "create table MEETINGS("
            +"  ID integer primary key autoincrement, "
            + "MEETING_ID int, "
            + "TIMESTAMP long";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_VERLAUF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS SCANITEM");
        onCreate(db);
    }
}
