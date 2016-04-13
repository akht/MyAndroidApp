package com.example.android.haikuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class HaikuAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater = null;
    List<HaikuItem> haikuList;

    public HaikuAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void setHaikuList(List<HaikuItem> haikuList) {
        this.haikuList = haikuList;
    }

    @Override
    public int getCount() {
        return haikuList.size();
    }

    @Override
    public Object getItem(int position) {
        return haikuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return haikuList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 独自に定義したリストビューアイテムのレイアウトをインフレートする
        convertView = layoutInflater.inflate(R.layout.list_item_haiku, parent, false);

        // setHaikuList()で受け取ったHaikuListを元にして、
        // list_item_haiku.xmlに定義された二つのTextViewに実体データをsetする
        ((TextView) convertView.findViewById(R.id.tv_haiku)).setText(haikuList.get(position).getHaikuString());
        ((TextView) convertView.findViewById(R.id.tv_author)).setText(haikuList.get(position).getAuthorString());
        return convertView;
    }
}
