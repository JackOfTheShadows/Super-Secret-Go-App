package com.example.go_app.go_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

public class TerminActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    ImageButton menu_button;
    Spinner spinnerGruppe;
    String[] auswahlGruppen = {"PSE Gruppe", "Kommilitionen", "Lern Gruppe"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termin);
        menu_button = (ImageButton) findViewById(R.id.menu_termine_termin);
        menu_button.setOnClickListener(this);


        spinnerGruppe = (Spinner) findViewById(R.id.spinnerGruppe);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String> (TerminActivity.this, android.R.layout.simple_spinner_dropdown_item, auswahlGruppen);
        spinnerGruppe.setAdapter(spinnerAdapter);
        spinnerGruppe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, TerminActivity.class);
        activity.startActivity(intent);
    }

    public void showPopUp(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(TerminActivity.this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_termin, popup.getMenu());
        popup.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menu_termine_termin) {
            showPopUp(v);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_termin:
                MainActivity.start(this);
                return true;
            case R.id.groups_termin:
                GroupsActivity.start(this);
                return true;
            case R.id.settings_termin:
                SettingsActivity.start(this);
                return true;
            case R.id.about_termin:
                AboutActivity.start(this);
                return true;
            default:
                return false;
        }
    }


}