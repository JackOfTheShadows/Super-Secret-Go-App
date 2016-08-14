package com.example.kansei.test_alarmreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by kansei on 07.07.16.
 */
public class GPS_Service extends IntentService{

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public GPS_Service(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("GPS_Service", "startet Server");
    }
}
