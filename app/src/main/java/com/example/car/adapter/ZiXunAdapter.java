package com.example.car.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;

import com.example.car.activity.ZiXunFragment;

/**
 * Created by 11355 on 2016/5/24.
 */
public class ZiXunAdapter extends FragmentPagerAdapter {
private Fragment i;

    public ZiXunAdapter(FragmentManager fm, ZiXunFragment i) {
        super(fm);
       this.i=i;
    }

    @Override
    public Fragment getItem(int position) {

        return  i;
    }

    @Override
    public int getCount() {
        return 1;
    }

}
