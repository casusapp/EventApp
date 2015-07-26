package com.ovent.eventapp.views.activity;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by parakhe on 7/25/15.
 */
public class Initialisation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "2YNVYaXRnRsEdGdy0tPMEdBW9qdNEgYcDdCFe36E", "ICgqYSgEpCcI6UHFgwOVuIH8EpKGeb1c4fX9j9NL");
        ParseFacebookUtils.initialize(this);
    }
}
