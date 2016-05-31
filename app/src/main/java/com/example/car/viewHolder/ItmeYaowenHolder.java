package com.example.car.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.car.R;

public class ItmeYaowenHolder extends RecyclerView.ViewHolder {
    private ImageView itemIvImg;
    private TextView itemTvTitle;
    private TextView itemTvTime;
    private TextView itemTvCount;

    public ItmeYaowenHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.itme_yaowen, parent, false));
    }

    public ItmeYaowenHolder(View view) {
        super(view);
        itemIvImg = (ImageView) view.findViewById(R.id.item_iv_img);
        itemTvTitle = (TextView) view.findViewById(R.id.item_tv_title);
        itemTvTime = (TextView) view.findViewById(R.id.item_tv_time);
        itemTvCount = (TextView) view.findViewById(R.id.item_tv_count);
    }

    public TextView getItemTvCount() {
        return itemTvCount;
    }

    public ImageView getItemIvImg() {
        return itemIvImg;
    }

    public TextView getItemTvTitle() {
        return itemTvTitle;
    }

    public TextView getItemTvTime() {
        return itemTvTime;
    }
}
