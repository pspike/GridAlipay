package com.example.sundychang.fragmenttabhost.CustomList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by sundychang on 15/9/22.
 */
public class SettingListView extends ListView{


    public SettingListView(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public SettingListView(Context context) {

        super(context);
    }

    public SettingListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

