package com.kevinjanvier.angalia;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.kevinjanvier.angalia.utility.Utility;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    ImageView check;
    FloatingActionButton fab;
    String DeviceVersionChecker;
    Utility utility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        utility = new Utility();

        check = (ImageView) findViewById(R.id.check_version);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        /**
         * UI
         */
        DeclareOnclick();
        CheckPhoneVersion();
    }

    /**
     * Check Phone Version
     */

    private void CheckPhoneVersion() {

    }

    /**
     * Declararion of My UI
     */

    private void DeclareOnclick() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceVersionChecker = Build.MODEL;
                log("===Phone Model =" + DeviceVersionChecker);
/**
 * Dialog Display
 */
                final SweetAlertDialog pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText(getString(R.string.please_wait));
                pDialog.setCancelable(false);
                pDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pDialog.dismiss();
                        if (DeviceVersionChecker.contains("SM-N930")){
                            log("Your Phone Will Explore  : " +DeviceVersionChecker);

                            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                    .setTitleText("Sweet!")
                                    .setContentText("Here's a custom image.")
                                    .setCustomImage(R.drawable.fire)
                                    .show();


                        }else {
                            log("Good Display Phone Version : " + DeviceVersionChecker);
                            Intent intent = new Intent(MainActivity.this, PhonePassed.class);
                            startActivity(intent);
                        }
                    }
                }, 3000);


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void log(String message){
        Log.v(this.getClass().getSimpleName(), message);
    }
}
