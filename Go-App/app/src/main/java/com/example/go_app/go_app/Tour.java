package com.example.go_app.go_app;

import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;

/**
 * Created by kansei on 10.06.16.
 */
public class Tour extends Meeting {

    public Tour(int id, String name, LatLng location, SimpleDateFormat timeStamp) {
        super(id, name, location, timeStamp);
    }
}
