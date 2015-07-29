package com.ovent.eventapp.views.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.ovent.eventapp.R;
import com.ovent.eventapp.views.fragments.HomeNavigationFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity{



    @Bind(R.id.DlHome)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.appbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        HomeNavigationFragment navigationFragment =
                (HomeNavigationFragment)getFragmentManager().findFragmentById(R.id.FgHomeNavigation);
        navigationFragment.setUp(mDrawerLayout,toolbar);

    }
}
