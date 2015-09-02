package com.ovent.eventapp.views.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ovent.eventapp.R;

public class MyStoryFragment extends Fragment {

    public MyStoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_my_story, container, false);
        return view;
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

}
