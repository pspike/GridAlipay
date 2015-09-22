package com.example.sundychang.fragmenttabhost;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment2 extends Fragment {

    private TextView textView;

    public Fragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, container, false);

        textView = (TextView) view.findViewById(R.id.tvSeneor);

        Context context = inflater.getContext();

        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> allSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);
        String s1 = ("该机共有以下 " + allSensor.size() + " 个传感器:\n");
        for (Sensor s : allSensor) {
            String s2 = ("\n 设备名称: " + s.getName() + "\n 版本: " + s.getVersion() + "\n 制造商: " + s.getVendor()+"\n");
            s1 = s1 + getSensorType(s) + s2;
        }

        textView.setText(s1);


        return view;
    }

    private String getSensorType(Sensor s) {
        switch (s.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                return s.getType() + ".加速度传感器accelerometer";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return s.getType() + ".电磁场传感器magnetic field";
            case Sensor.TYPE_ORIENTATION:
                return s.getType() + ".方向传感器orientation";
            case Sensor.TYPE_GYROSCOPE:
                return s.getType() + ".陀螺仪传感器gyroscope";
            case Sensor.TYPE_LIGHT:
                return s.getType() + ".环境光线传感器light";
            case Sensor.TYPE_PRESSURE:
                return s.getType() + ".压力传感器pressure";
            case Sensor.TYPE_TEMPERATURE:
                return s.getType() + ".温度传感器temperature";
            case Sensor.TYPE_PROXIMITY:
                return s.getType() + ".距离传感器proximity";
            case Sensor.TYPE_GRAVITY:
                return s.getType() + ".重力传感器gravity";
            case Sensor.TYPE_LINEAR_ACCELERATION:
                return s.getType() + ".线性加速传感器linear acceleration";
            case Sensor.TYPE_ROTATION_VECTOR:
                return s.getType() + ".旋转矢量传感器rotation vector";
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return s.getType() + ".相对湿度传感器relative humidity";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return s.getType() + ".环境温度传感器ambient temperature";
            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                return s.getType() + ".未校准的磁场传感器magnetic field uncalibrated";
            case Sensor.TYPE_GAME_ROTATION_VECTOR:
                return s.getType() + ".游戏旋转矢量game rotation vector";
            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                return s.getType() + ".未校准的陀螺仪";
            case Sensor.TYPE_SIGNIFICANT_MOTION:
                return s.getType() + ".TYPE_SIGNIFICANT_MOTION";
            case Sensor.TYPE_STEP_DETECTOR:
                return s.getType() + ".步测器 step detector";
            case Sensor.TYPE_STEP_COUNTER:
                return s.getType() + ".计步器step counter";
            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                return s.getType() + ".磁力计geomagnetic rotation vector";
            case Sensor.TYPE_HEART_RATE:
                return s.getType() + ".心率计 heart rate";
//            case Sensor.TYPE_TILT_DETECTOR:
//                return s.getType() + ".加速度传感器accelerometer";
//            case Sensor.TYPE_WAKE_GESTURE:
//                return s.getType() + ".加速度传感器accelerometer";
//            case Sensor.TYPE_GLANCE_GESTURE:
//                return s.getType() + ".加速度传感器accelerometer";
//            case Sensor.TYPE_PICK_UP_GESTURE:
//                return s.getType() + ".加速度传感器accelerometer";
//            case Sensor.TYPE_WRIST_TILT_GESTURE:
//                return s.getType() + ".加速度传感器accelerometer";
            default:
                return s.getType() + ".无法识别的传感器";
        }
    }
}
