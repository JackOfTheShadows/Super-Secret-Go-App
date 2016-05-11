package com.example.go_app.go_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    ImageButton menu_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_button = (ImageButton) findViewById(R.id.menu_termine);
        menu_button.setOnClickListener(this);
    }

    public void showPopUp(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(MainActivity.this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        popup.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menu_termine) {
            showPopUp(v);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.neuer_termin_main:
                Log.i("my", "termint");
                return true;
            case R.id.groups_main:
                Log.i("my", "groups");
                return true;
            case R.id.settings_main:
                SettingsActivity.start(this);
                return true;
            case R.id.about_main:
                AboutActivity.start(this);
                return true;
            default:
                return false;
        }
    }

}
