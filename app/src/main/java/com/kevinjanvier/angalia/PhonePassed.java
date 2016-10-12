package com.kevinjanvier.angalia;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PhonePassed extends AppCompatActivity {

    String PhoneModel;
    String Phone, Manufacturer, Serial, device, display;
    TextView serial_n, model,manufacturer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_passed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Phone Checker");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        CheckPhoneDetails();

    }

    private void CheckPhoneDetails() {

        PhoneModel = Build.MODEL;
        Manufacturer = Build.MANUFACTURER;
        Serial = Build.SERIAL;
        device = Build.DEVICE;
        display = Build.DISPLAY;

        serial_n = (TextView) findViewById(R.id.serial_number);
        serial_n.setText(Serial);
        model = (TextView) findViewById(R.id.model);
        model.setText(PhoneModel);
        manufacturer = (TextView) findViewById(R.id.manufacturer);
        manufacturer.setText(Manufacturer);

        log("Phone Model " + PhoneModel);
        log("Manifacture " + Manufacturer);
        log("Serial : " + Serial);
        log("Device : " + device);
        log("Display : " +display);
    }

    private void log(String msg){
        Log.v(this.getClass().getSimpleName(), msg);
    }
}
