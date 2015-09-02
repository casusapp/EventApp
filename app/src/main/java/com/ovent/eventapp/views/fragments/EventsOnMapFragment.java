package com.ovent.eventapp.views.fragments;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.ovent.eventapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class EventsOnMapFragment extends Fragment implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener{
    public static final String TAG = "##EventsOnMapFragment##";

    @Bind(R.id.back)
    ImageView mBack;

    @Bind(R.id.map)
    MapView mMapView;

    public EventsOnMapFragment() {
    }

    public static EventsOnMapFragment GetInstance(){
        return new EventsOnMapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_events_on_map, container, false);
        ButterKnife.bind(this, view);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        mMapView.onCreate(savedInstanceState);
        SupportMapFragment mMapView = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        mMapView.getMapAsync(this);

        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG,"map is working");
        googleMap.setMyLocationEnabled(true);
       // putEventsOnMaps(googleMap);

    }

    private void putEventsOnMaps(GoogleMap googleMap) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
