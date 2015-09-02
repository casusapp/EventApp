package com.ovent.eventapp.views.activity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ovent.eventapp.R;
import com.ovent.eventapp.views.fragments.EventsOnMapFragment;

public class EventsOnMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_on_map);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, EventsOnMapFragment.GetInstance(), EventsOnMapFragment.TAG);
        transaction.commit();

    }

}
