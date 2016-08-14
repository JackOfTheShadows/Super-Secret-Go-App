package com.example.kansei.test_alarmreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  VerlaufDataSource dataSource;
    List<Entry> RechnungsList = new ArrayList<Entry>();


    AlarmManager alarmManager;
    PendingIntent alarmIntent;
    Button setAlarmButton, deletAlarmButton;

    TimePicker timePicker;

    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarmButton = (Button) findViewById(R.id.setAlarmReceiverButton);
        deletAlarmButton = (Button) findViewById(R.id.deletReceiverButton);
        timePicker = (TimePicker) findViewById(R.id.timePicker);


        this.context = this;

        dataSource = new VerlaufDataSource(this);
    }




     // @TargetApi(Build.VERSION_CODES.M)
    public void setAlarmReceiver(View view) {

        timePicker = (TimePicker) findViewById(R.id.timePicker);

         timePicker.clearFocus();
         int hour = timePicker.getCurrentHour();
         int minute = timePicker.getCurrentMinute();


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);

        alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent,0);
        // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
        //         calendar.getTimeInMillis(), 2*60*1000,alarmIntent);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), 30*1000,alarmIntent);
        Toast.makeText(this, "Alarm Manager erstellt", Toast.LENGTH_SHORT).show();
    }

    public void deletReceiver(View view) {
        /*
        if ( alarmManager != null) {
            alarmManager.cancel(alarmIntent);
        } */
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.cancel(alarmIntent);
    }

























































    public void setEntryInDb(View view) {

        try {
            dataSource.open();
            dataSource.createEntry(69, 1471027427000L);
            dataSource.close();

        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void getEntryFromDb(View view) {
        RechnungsList.clear();

        try {
            dataSource.open();
            RechnungsList = dataSource.getAllEntries();
            dataSource.close();
        }
        catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
