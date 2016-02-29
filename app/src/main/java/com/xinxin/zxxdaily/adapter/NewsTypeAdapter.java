package com.xinxin.zxxdaily.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xinxin.zxxdaily.R;
import com.xinxin.zxxdaily.model.NewsListItem;

import java.util.List;

/**
 * Created by xinxin on 2016年2月27日21:12:29
 * 新闻类型列表适配器
 */
public class NewsTypeAdapter extends BaseAdapter {

    private Context context;
    private List<NewsListItem> items;

    public NewsTypeAdapter(Context context,List<NewsListItem> items) {
        this.context = context;
        this.items = items;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_menu_item, viewGroup, false);
        }
        TextView tv_item = (TextView) convertView.findViewById(R.id.tv_item);
        tv_item.setText(items.get(i).getTitle());

        return convertView;
    }
}




























