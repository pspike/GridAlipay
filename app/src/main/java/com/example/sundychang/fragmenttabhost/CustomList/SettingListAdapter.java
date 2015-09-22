package com.example.sundychang.fragmenttabhost.CustomList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sundychang.fragmenttabhost.GridView.BaseViewHolder;
import com.example.sundychang.fragmenttabhost.R;

public class SettingListAdapter extends BaseAdapter {


    private Context context;

    public SettingListAdapter(Context context) {

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
    private int[] iconRinght = {R.drawable.arrow_gray_next, R.drawable.arrow_gray_next,
        R.drawable.arrow_gray_next, R.drawable.arrow_gray_next, R.drawable.arrow_gray_next};


    @Override
    public int getCount() {
        return iconID.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        System.out.println(">>>>>>>>>>>>>>Settings GetView");

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.setting_list_item,null);
        }


        TextView tvTitle = BaseViewHolder.get(convertView, R.id.tvSettingTitle);
//        TextView tvDec = BaseViewHolder.get(convertView, R.id.tvSettingDesc);
        ImageView iv = BaseViewHolder.get(convertView, R.id.ivSettingItem);
        ImageView ivRight = BaseViewHolder.get(convertView, R.id.ivSettingsRightItem);


            iv.setImageResource(iconID[position]);


            ivRight.setImageResource(iconRinght[position]);

            tvTitle.setText(text[position]);


        return convertView;
    }

}
