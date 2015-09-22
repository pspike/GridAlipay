package com.example.sundychang.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sundychang.fragmenttabhost.CustomList.SettingListAdapter;
import com.example.sundychang.fragmenttabhost.CustomList.SettingSwitcherListAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment5 extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView lv,lvSwitch;

    public Fragment5() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment5, container, false);

        lvSwitch = (ListView)rootView.findViewById(R.id.lvSettingSwitch);
        lvSwitch.setAdapter(new SettingSwitcherListAdapter(inflater.getContext()));

        lv = (ListView)rootView.findViewById(R.id.lvSetting);
        lv.setAdapter(new SettingListAdapter(inflater.getContext()));

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0:
            Toast.makeText(parent.getContext(), "应用介绍", Toast.LENGTH_SHORT).show();
                break;
            case 2:
            Toast.makeText(parent.getContext(), "评分", Toast.LENGTH_SHORT).show();
                break;
            case 3:
            Toast.makeText(parent.getContext(), "反馈", Toast.LENGTH_SHORT).show();
                break;
            case 4:
            Toast.makeText(parent.getContext(), "Update", Toast.LENGTH_SHORT).show();
                break;
            case 5:
            Toast.makeText(parent.getContext(), "about", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onClick(View v) {
        System.out.println();
        }
}
