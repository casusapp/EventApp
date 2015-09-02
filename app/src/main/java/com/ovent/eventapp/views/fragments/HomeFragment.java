package com.ovent.eventapp.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.ovent.eventapp.R;
import com.ovent.eventapp.views.activity.MapsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {

@Bind(R.id.startnv)
    Button mStartnv;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        mStartnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationManager checkgps = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                boolean enabled = checkgps.isProviderEnabled(LocationManager.GPS_PROVIDER);

                    Uri currentlocuri = Uri.parse("google.navigation:q=Balewadi+phata,PUNE");
                    Intent navigationIntent = new Intent(Intent.ACTION_VIEW, currentlocuri);
                    navigationIntent.setPackage("com.google.android.apps.maps");

                    if (navigationIntent.resolveActivity(getActivity().getPackageManager()) != null) {

                        startActivity(navigationIntent);

                    } else {
                        String appnotinstall = "Navigation app is not installed in this phone.";
                        Toast.makeText(getActivity().getApplicationContext(), appnotinstall, Toast.LENGTH_SHORT).show();
                    }

                }
        });

        return view;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
