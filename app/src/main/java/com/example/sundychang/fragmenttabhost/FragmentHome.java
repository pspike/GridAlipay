package com.example.sundychang.fragmenttabhost;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.sundychang.fragmenttabhost.GridView.MyGridAdapter;
import com.example.sundychang.fragmenttabhost.GridView.MyGridView;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentHome extends Fragment implements AdapterView.OnItemClickListener {

    private MyGridView gridview;
    Context context;

    public FragmentHome() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        context = inflater.getContext();
        gridview=(MyGridView)view.findViewById(R.id.gridview);

        gridview.setOnItemClickListener(this);


        gridview.setAdapter(new MyGridAdapter(inflater.getContext()));

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0:
//                Toast.makeText(context,"1.淘宝电影",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().addToBackStack(null).
                        replace(R.id.realtabcontent, new fragment_acceleromenter()).commit();
                break;
            case 1:
                getFragmentManager().beginTransaction().addToBackStack(null).
                        replace(R.id.realtabcontent, new fragment_bluetooth()).commit();

//                Toast.makeText(parent.getContext(),"2.彩票",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(parent.getContext(),"3.当面付",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(parent.getContext(),"4.亲密付",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(parent.getContext(),"5.机票",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(parent.getContext(),"6.淘宝电影",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(parent.getContext(),"7.淘宝电影",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(parent.getContext(),"8.淘宝电影",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(parent.getContext(),"9.淘宝电影",Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(parent.getContext(),"10.淘宝电影",Toast.LENGTH_SHORT).show();
                break;
            case 10:
                Toast.makeText(parent.getContext(),"11.淘宝电影",Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(parent.getContext(),"12.淘宝电影",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
