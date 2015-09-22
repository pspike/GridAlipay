package com.example.sundychang.fragmenttabhost;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sundychang on 15/9/22.
 */
public class fragment_acceleromenter extends Fragment implements SensorEventListener {

    private BluetoothAdapter mBluetoothAdapter;
    private TextView textView;
    private View rootView;
    private Context context;
    private SensorManager sensorManager;

    private boolean isRegisitedAcc = false;
    private boolean isRegisitedGry = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_accelerometer, container, false);

        context = inflater.getContext();
        textView = (TextView) rootView.findViewById(R.id.tvAcc);

        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);


        return rootView;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER: //加速度
                String s;
                s = "加速度原始值:\n X :" + event.values[0] + "\n Y: " +
                        event.values[1] + "\n Z:" + event.values[2];

                textView.setText(s);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }

    @Override
    public void onResume() {
        super.onResume();

        Sensor sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensorAcc != null) {
            isRegisitedAcc = sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_UI);
        } else {
            System.out.println("没找到加速度传感器 Accelerometer");
        }

        Sensor sensorGry = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        if(sensorGry != null) {
            isRegisitedGry = sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            System.out.println("没找到重力传感器 Accelerometer");
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }
}
