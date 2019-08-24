package com.test.tddjunit5example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Flight economyFlight = new EconomyFlight("1");
        Flight businessFlight = new BusinessFlight("2");

        Passenger john = new Passenger("John", true);
        Passenger mike = new Passenger("Mike", false);

        businessFlight.addPassenger(john);
        businessFlight.removePassenger(john);
        economyFlight.addPassenger(mike);
        economyFlight.removePassenger(mike);

        Log.v(TAG,"Business flight passengers list");
        for(Passenger passenger:businessFlight.getPassengerList()) {
            Log.v(TAG,passenger.getName());
        }
        Log.v(TAG,"Economy flight passengers list");
        for(Passenger passenger:economyFlight.getPassengerList()) {
            Log.v(TAG,passenger.getName());
        }
    }
}
