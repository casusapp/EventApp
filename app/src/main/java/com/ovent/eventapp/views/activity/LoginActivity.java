package com.ovent.eventapp.views.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.ovent.eventapp.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends ActionBarActivity {

    @Bind(R.id.EtUsername)
    EditText username;

    @Bind(R.id.EtPassword)
    EditText password;

    @Bind(R.id.TvLoginError)
    TextView loginError;

    @Bind(R.id.BtLogin) Button login;
    @OnClick(R.id.BtLogin)
    public void Login(){
        if(isConnectingToInternet()){
            String usernameVal = username.getText().toString();
            String passwordVal = password.getText().toString();
            ParseUser.logInInBackground(usernameVal,passwordVal,new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if(e == null){
                        Log.d("app","successfully logged in");
                    }else{
                        Log.d("app",e.getCode()+"   "+e.getMessage());
                        loginError.setVisibility(View.VISIBLE);
                    }
                }
            });

        }else{
            Typeface titleFont = Typeface.createFromAsset(this.getAssets(),"fonts/proxima-nova-semi-bold.otf");
            Typeface bodyFont = Typeface.createFromAsset(this.getAssets(),"fonts/proxima-nova-light.otf");
            new MaterialDialog.Builder(this)
                    .title("Internet Failure")
                    .titleColor(getResources().getColor(R.color.dialog_title))
                    .typeface(titleFont,bodyFont)
                    .content("Check your internet connection and try again")
                    .positiveText("Ok")
                    .show();
        }
        Log.d("app","internet is not connected");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Typeface font = Typeface.createFromAsset(this.getAssets(),"fonts/proxima-nova-semi-bold.otf");
        username.setTypeface(font);
        password.setTypeface(font);
        login.setTypeface(font);
        YoYo.with(Techniques.Shake).duration(2000).playOn(username);
        YoYo.with(Techniques.Shake).duration(2000).playOn(password);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if(currentUser == null){
            //Intent checkConnection = new Intent();
            //checkConnection.setAction("android.net.conn.CONNECTIVITY_CHANGE");
            //sendBroadcast(checkConnection);
        }else{

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isConnectingToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
