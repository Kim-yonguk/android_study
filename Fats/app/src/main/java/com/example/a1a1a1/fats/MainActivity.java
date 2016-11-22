package com.example.a1a1a1.fats;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView countnumber;
    static double acceleration =0;
    static int dir_UP=0;
    static int dir_DOWN=0;
    static int count=0;
    static double gravity=9.8;




    private SensorManager mSM;

    private Sensor myGravity;
    private Sensor myAccel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countnumber=(TextView)findViewById(R.id.txt2);
        mSM = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        myGravity = mSM.getDefaultSensor(Sensor.TYPE_GRAVITY);
        myAccel= mSM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSM.registerListener(mySensorListener, myGravity,
                SensorManager.SENSOR_DELAY_NORMAL);
        mSM.registerListener(mySensorListener, myAccel,
                SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    protected void onStart() {
        super.onStart();

        mSM.registerListener(mySensorListener, myGravity,
                SensorManager.SENSOR_DELAY_GAME);

        mSM.registerListener(mySensorListener, myAccel,
                SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onPause() {
        super.onPause();

        mSM.unregisterListener(mySensorListener);
    }

    public SensorEventListener mySensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {

            if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                float x=event.values[0];
                float y=event.values[1];
                float z=event.values[2];
                acceleration=Math.sqrt(x*x+y*y+z*z);
            }

            if(acceleration-gravity>5) {
                dir_UP=1;
            }
            if(dir_UP==1&&gravity-acceleration>5) {
                dir_DOWN=1;
            }
            if(dir_DOWN==1){
                count++;
                countnumber.setText(""+count);

                dir_UP=0;
                dir_DOWN=0;

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

}


