package com.example.sundychang.fragmenttabhost;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Set;

/**
 * Created by sundychang on 15/9/22.
 */
public class fragment_bluetooth extends Fragment {

    private BluetoothAdapter mBluetoothAdapter;
    TextView textView;
    View rootView;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_bluetooth, container, false);

        context = inflater.getContext();
        textView = (TextView) rootView.findViewById(R.id.tvBluetooth);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter != null) {

            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

            if (pairedDevices.size() > 0) {
                for (BluetoothDevice device : pairedDevices) {
                    textView.append(device.getAddress() + ":" + device.getAddress() + "\n");
                }
            }

            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            context.registerReceiver(receiver, filter);

            filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
            context.registerReceiver(receiver, filter);


            rootView.findViewById(R.id.btnSerach).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //                setProgressBarIndeterminate(true);

                    if (mBluetoothAdapter.isDiscovering()) {
                        mBluetoothAdapter.cancelDiscovery();
                    }
                    System.out.println("开始搜索...");
                    mBluetoothAdapter.startDiscovery();

                }
            });
        }else{
            System.out.println(">>>>>>>no bluetooth adapter");
        }


        return rootView;
    }


    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    textView.append(device.getName() + ":" + device.getAddress() + "\n");
                }
            } else if ((BluetoothAdapter.ACTION_DISCOVERY_FINISHED).equals(action)) {
                System.out.println("搜索已完成");
            }
        }
    };
}
