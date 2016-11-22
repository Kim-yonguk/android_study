package com.example.a1a1a1.sensortest;

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

    private TextView gx;
    private TextView gy;
    private TextView gz;

    private TextView ax;
    private TextView ay;
    private TextView az;

    private TextView lx;
    private TextView ly;
    private TextView lz;

    private TextView GYx;
    private TextView GYy;
    private TextView GYz;



    private SensorManager mSM;

    private Sensor myGravity;
    private Sensor myAccel;
    private Sensor myLinear;
    private Sensor myGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnstart=(Button)findViewById(R.id.btn_start);
        Button btnend=(Button)findViewById(R.id.btn_end);

        gx = (TextView) findViewById(R.id.g_x1);
        gy = (TextView) findViewById(R.id.g_x2);
        gz = (TextView) findViewById(R.id.g_x3);

        ax = (TextView) findViewById(R.id.a_x1);
        ay = (TextView) findViewById(R.id.a_x2);
        az = (TextView) findViewById(R.id.a_x3);

        lx = (TextView) findViewById(R.id.l_x1);
        ly = (TextView) findViewById(R.id.l_x2);
        lz = (TextView) findViewById(R.id.l_x3);

        GYx = (TextView) findViewById(R.id.gy_x1);
        GYy = (TextView) findViewById(R.id.gy_x2);
        GYz = (TextView) findViewById(R.id.gy_x3);



        mSM = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        myGravity = mSM.getDefaultSensor(Sensor.TYPE_GRAVITY);
        myAccel= mSM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        myLinear=mSM.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        myGyro=mSM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        mSM.registerListener(mySensorListener, myGravity,
                SensorManager.SENSOR_DELAY_NORMAL);
        mSM.registerListener(mySensorListener, myAccel,
                SensorManager.SENSOR_DELAY_NORMAL);
        mSM.registerListener(mySensorListener, myLinear,
                SensorManager.SENSOR_DELAY_NORMAL);
        mSM.registerListener(mySensorListener, myGyro,
                SensorManager.SENSOR_DELAY_NORMAL);
        /*
        btnstart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onStart();
                    }
                }
        );
        btnend.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        onPause();
                    }
                }
        );*/
    }


    @Override
    protected void onStart() {
        super.onStart();

        mSM.registerListener(mySensorListener, myGravity,
                SensorManager.SENSOR_DELAY_GAME);

        mSM.registerListener(mySensorListener, myAccel,
                SensorManager.SENSOR_DELAY_GAME);

        mSM.registerListener(mySensorListener, myLinear,
                SensorManager.SENSOR_DELAY_GAME);
        mSM.registerListener(mySensorListener, myGyro,
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

            switch(event.sensor.getType()){
                case Sensor.TYPE_GRAVITY:
                    gx.setText("X: "+event.values[0]);
                    gy.setText("Y: "+event.values[1]);
                    gz.setText("Z: "+event.values[2]);
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    ax.setText("X: "+event.values[0]);
                    ay.setText("Y: "+event.values[1]);
                    az.setText("Z: "+event.values[2]);
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    lx.setText("X: "+event.values[0]);
                    ly.setText("Y: "+event.values[1]);
                    lz.setText("Z: "+event.values[2]);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    GYx.setText("X: "+event.values[0]);
                    GYy.setText("Y: "+event.values[1]);
                    GYz.setText("Z: "+event.values[2]);
                    break;
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

}

