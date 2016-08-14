package com.example.kansei.test_alarmreceiver;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by kansei on 07.07.16.
 */
public class AlarmReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("AlarmReceiver", "Good Morning!");

        // Start GPS service
        Intent serviceIntent = new Intent(context,GPS_Service.class );

        /*Put extra in the intent ?
        serviceIntent.putExtra("keyWord", "Something/can be also a int,boolea,...")
        */
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        context.startService(serviceIntent);

    }
}
