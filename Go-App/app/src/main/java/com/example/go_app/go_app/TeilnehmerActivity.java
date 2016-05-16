package com.example.go_app.go_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class TeilnehmerActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    ImageButton menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teilnehmer);
        menu_button = (ImageButton) findViewById(R.id.menu_teilnehmer);
        menu_button.setOnClickListener(this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, TeilnehmerActivity.class);
        activity.startActivity(intent);
    }

    public void showPopUp(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(TeilnehmerActivity.this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_teilnehmer, popup.getMenu());
        popup.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menu_teilnehmer) {
            showPopUp(v);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_teilnehmer:
                TeilnehmerActivity.start(this);
                return true;
            case R.id.neuer_termin_teilnehmer:
                TerminActivity.start(this);
                return true;
            case R.id.groups_teilnehmer:
                GroupsActivity.start(this);
                return true;
            case R.id.settings_teilnehmer:
                SettingsActivity.start(this);
                return true;
            case R.id.about_teilnehmer:
                AboutActivity.start(this);
                return true;
            default:
                return false;
        }
    }

}
