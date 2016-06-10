package com.example.go_app.go_app;

import java.text.SimpleDateFormat;
import java.util.List;

import com.google.android.gms.maps.model.LatLng;


/**
 * Created by kansei on 10.06.16.
 */
public abstract class Meeting {

    private int id;
    private String name;
    private SimpleDateFormat timeStamp;
    private int duration;
    // oder? private long timeStamp;
    // private Participant creator;
    // private List<Participent> participants;
    private LatLng location;


    public Meeting (int id, String name, LatLng location, SimpleDateFormat timeStamp) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.timeStamp  = timeStamp;

    }


    public int getID() {

        return id;
    }

    public String getName() {
        return name;
    }

    public SimpleDateFormat getTimeStamp() {
        return timeStamp;
    }

    /*
    public Participant getCreator() {
        return creator;
    }
    */

    /*
    public List<Participant> getParticipants() {
        return participants;
    }
    */







}
