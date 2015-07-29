package com.ovent.eventapp.views.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import com.ovent.eventapp.R;
import com.ovent.eventapp.views.fragments.HomeNavigationFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity{



  /*  @Bind(R.id.DlHome)
    DrawerLayout mDrawerLayout;
*/
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    //@Bind(R.id.TabView) TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    /* HomeNavigationFragment navigationFragment =
                (HomeNavigationFragment)getFragmentManager().findFragmentById(R.id.FgHomeNavigation);
        navigationFragment.setUp(mDrawerLayout,toolbar);*/

       toolbar.setTitle("This works");
    }

}
