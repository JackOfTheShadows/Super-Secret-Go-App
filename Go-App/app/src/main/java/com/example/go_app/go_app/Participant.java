package com.example.go_app.go_app;

/**
 * Created by kansei on 10.06.16.
 */
public class Participant {

    private int id;
    private String userName;

    public Participant (int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return userName;
    }
}
