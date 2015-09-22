package com.example.sundychang.fragmenttabhost.CustomList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sundychang.fragmenttabhost.GridView.BaseViewHolder;
import com.example.sundychang.fragmenttabhost.R;

public class SettingSwitcherListAdapter extends BaseAdapter {


    private Context context;

    public SettingSwitcherListAdapter(Context context) {

        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    private String[] text = {"应用介绍","去五星评分", "帮助和反馈","检查更新","关于" };
    private int[] iconID  = {R.drawable.settings_notification,R.drawable.settings_competition,
            R.drawable.settings_feedback,R.drawable.settings_healthcenter,R.drawable.settings_rate
    };
    private boolean[] cb = {false, false, false, false, false};


    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        System.out.println(">>>>>>>>>>>>>>Settings Switch GetView");

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.setting_switcher_list_item,null);
        }

        TextView tvTitle = BaseViewHolder.get(convertView, R.id.tvTitle);
        ImageView iv = BaseViewHolder.get(convertView, R.id.ivItem);
        CheckBox cb = BaseViewHolder.get(convertView, R.id.cbSwitcher);


            iv.setImageResource(iconID[position]);
//        if (data.getCbChecked()) {
//            cb.setBackground(R.drawable.switch_on);
//        }

            tvTitle.setText(text[position]);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("chenced:" + position);
                switch (position) {
                    case 0:
                        Toast.makeText(parent.getContext(),"checked 1",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(parent.getContext(),"checked 2",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(parent.getContext(),"checked 3",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        return convertView;
    }

}
