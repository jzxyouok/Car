package com.example.car.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.car.R;
import com.example.car.bean.Content;
import com.example.car.view.PinnedHeaderListView;
import com.example.car.viewHolder.ListviewItemPinpaiHolder;
import com.example.car.zhaochefragment.PinPaiFragment;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by 11355 on 2016/5/30.
 */
public class PinYinAdapter extends BaseAdapter implements PinnedHeaderListView.PinnedHeaderAdapter,AbsListView.OnScrollListener {


    private  View view;
    private  LayoutInflater inflater;
    private  ArrayList<Content> datalist;


    public PinYinAdapter(Context content,View view, ArrayList<Content> dataList) {
        inflater = LayoutInflater.from(content);
        this.datalist=dataList;
        this.view=view;

    }
    /**
     * 返回当前首字母出现的第一个位置
     */
    public int getPositionForSection(int section)
    {
        for (int i = 0; i < getCount(); i++)
        {
            char firstChar = datalist.get(i).getLetter().toUpperCase(Locale.CHINA).charAt(0);
            if (firstChar == section)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回当前位置的首字母
     */
    public int getSectionForPosition(int position)
    {
        return datalist.get(position).getLetter().toUpperCase(Locale.CHINA).charAt(0);
    }


    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListviewItemPinpaiHolder holder=null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.listview_item_pinpai,null);
           holder= new ListviewItemPinpaiHolder(convertView);
            convertView.setTag(holder);


        }
        else {
            holder= (ListviewItemPinpaiHolder) convertView.getTag();
        }
        int section=getSectionForPosition(position);
        if (getPositionForSection(section)==position){
            holder.getListHeader().setVisibility(View.VISIBLE);
            holder.getListHeaderText().setText(datalist.get(position).getLetter().toUpperCase(Locale.CHINA).charAt(0)+"");

        }
        else {
            holder.getListHeader().setVisibility(View.GONE);

        }
        holder.getListItemContentText().setText(datalist.get(position).getName());

        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
if (view instanceof PinnedHeaderListView){
    ((PinnedHeaderListView) view).configureHeaderView(firstVisibleItem);
}
    }
    private int mLocationPosition = -1;
    @Override
    public int getPinnedHeaderState(int position) {
        int realPosition = position;
        if (realPosition < 0 || (mLocationPosition != -1 && mLocationPosition == realPosition))
        {
            return PINNED_HEADER_GONE;
        }
        mLocationPosition = -1;
        int nextSection = getSectionForPosition(realPosition+1);
        int nextSectionPosition = getPositionForSection(nextSection);
        if (nextSectionPosition != -1 && realPosition == nextSectionPosition - 1)
        {
            return PINNED_HEADER_PUSHED_UP;
        }
        return PINNED_HEADER_VISIBLE;
    }

    @Override
    public void configurePinnedHeader(View header, int position, int alpha) {
        ((TextView)header.findViewById(R.id.list_header_text)).setText(datalist.get(position).getLetter().toUpperCase(Locale.CHINA).charAt(0)+"");
    }
}
