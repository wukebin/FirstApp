package com.example.myfirstapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayAMActivity extends AppCompatActivity implements SensorEventListener {
    private String x, y, z;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView t0, t1, t2;
    private CountDownTimer cd;
    private int delay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_am);
        t0 = (TextView) findViewById(R.id.t0);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        /*t0.setText("X: " + x);
        t1.setText("Y: " + y);
        t2.setText("Z: " + z);*/
        cd = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                delay = 0;
            }
        };
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
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
        if (delay == 0) {
            x = String.valueOf(event.values[0]);
            y = String.valueOf(event.values[1]);
            z = String.valueOf(event.values[2]);
            t0.setText("X: " + x);
            t1.setText("Y: " + y);
            t2.setText("Z: " + z);
            delay = 1;
            cd.start();
        }
    }

}

