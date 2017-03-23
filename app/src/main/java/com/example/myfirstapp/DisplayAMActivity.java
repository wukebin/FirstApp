    package com.example.myfirstapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

    public class DisplayAMActivity extends AppCompatActivity implements SensorEventListener {

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_am);
        private final SensorManager mSensorManager;
        private final Sensor mAccelerometer;
        private String x;
        private String y;
        private String z;

         public DisplayAMActivity() {
            mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
            mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        protected void onResume() {
            super.onResume();
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        protected void onPause() {
            super.onPause();
            mSensorManager.unregisterListener(this);
        }


        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent event) {
            x = String.valueOf(event.values[0]);
            y = String.valueOf(event.values[1]);
            z = String.valueOf(event.values[2]);
        }

       //TextView textView = (TextView) findViewById();

       // textView.setText();
    }

