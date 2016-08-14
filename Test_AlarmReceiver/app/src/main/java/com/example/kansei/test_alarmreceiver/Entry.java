package com.example.kansei.test_alarmreceiver;

import java.util.Calendar;

/**
 * Created by kansei on 06.07.16.
 * Zwischen speicher für adaper und Db
 */
public class Entry {
    private long id;
    private int meetingId;
    private long timestamp;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {

        // long TimeStampt umrechnen
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        String year = Long.toString(calendar.get(Calendar.YEAR));
        String month = Long.toString(calendar.get(Calendar.MONTH));
        String dayOfMonth = Long.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String hour = Long.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = Long.toString(calendar.get(Calendar.MINUTE));



        return String.format("Meeting mit Id: " + meetingId + " ist am " + dayOfMonth + "." + month + "." + year + " um " + hour + ":" + minute);
    }
}
