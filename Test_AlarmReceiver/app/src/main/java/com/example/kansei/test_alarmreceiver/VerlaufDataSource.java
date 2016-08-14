package com.example.kansei.test_alarmreceiver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kansei on 06.07.16.
 */
public class VerlaufDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColums = {"ID", "MEETING_ID", "TIMESTAMP"};


    public VerlaufDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Entry createEntry(int meetingId, long timeStamp) {
        ContentValues values = new ContentValues();
        values.put("MEETING_ID", meetingId);
        values.put("TIMESTAMP", timeStamp);


        long insertId = database.insert("MEETINGS", null, values);

        // trägt die daten rein
        Cursor cursor = database.query("MEETINGS", allColums, "ID = "+ insertId, null,null,null,null);
        cursor.moveToFirst();

        return cursorToEntry(cursor);
    }

    protected List<Entry> getAllEntries() {
        List<Entry> entriesList = new ArrayList<Entry>();
        entriesList = new ArrayList<Entry>();

        Cursor cursor = database.query("MEETINGS", allColums, null, null, null, null, null);
        cursor.moveToFirst();

        if (cursor.getCount() == 0) return entriesList;

        while (cursor.isAfterLast() == false) {
            Entry entry = cursorToEntry(cursor);
            entriesList.add(entry);
            cursor.moveToNext();
        }
        return entriesList;
    }

    private Entry cursorToEntry(Cursor cursor) {
        Entry entry = new Entry();
        entry.setId(cursor.getLong(0));
        entry.setMeetingId(cursor.getInt(1));
        entry.setTimestamp(cursor.getLong(2));

        return entry;
    }



}
