package com.example.car.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.car.R;

public class ListviewItemPinpaiHolder extends RecyclerView.ViewHolder {
    private LinearLayout listHeader;
    private TextView listHeaderText;
    private LinearLayout listItemContent;
    private TextView listItemContentText;

    public ListviewItemPinpaiHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.listview_item_pinpai, parent, false));
    }

    public ListviewItemPinpaiHolder(View view) {
        super(view);
        listHeader = (LinearLayout) view.findViewById(R.id.list_header);
        listHeaderText = (TextView) listHeader.findViewById(R.id.list_header_text);
        listItemContent = (LinearLayout) view.findViewById(R.id.list_item_content);
        listItemContentText = (TextView) listItemContent.findViewById(R.id.list_item_content_text);
    }

    public LinearLayout getListHeader() {
        return listHeader;
    }

    public TextView getListItemContentText() {
        return listItemContentText;
    }

    public TextView getListHeaderText() {
        return listHeaderText;
    }

    public LinearLayout getListItemContent() {
        return listItemContent;
    }
}
