package com.xinxin.zxxdaily.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;
import com.xinxin.zxxdaily.R;
import com.xinxin.zxxdaily.activity.MainActivity;
import com.xinxin.zxxdaily.adapter.MainNewsItemAdapter;
import com.xinxin.zxxdaily.model.Before;
import com.xinxin.zxxdaily.model.Latest;
import com.xinxin.zxxdaily.model.StoriesEntity;
import com.xinxin.zxxdaily.util.Constant;
import com.xinxin.zxxdaily.util.HttpUtils;
import com.xinxin.zxxdaily.view.Kanner;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xinxin on 2016/2/27.
 * 2016年2月27日21:53:34
 * 主页碎片
 */
public class MainFragment extends BaseFragment implements View.OnClickListener {

    private ListView lv_news;
    private List<Latest> latests;
    private Latest latest;
    private Kanner kanner;
    private Handler handler = new Handler();

    private String date;
    private boolean isLoading = false;
    private Before before;

    private MainNewsItemAdapter mAdapter;

    @Override
    protected View initView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        // 通信？？？
        ((MainActivity) mActivity).setToolbarTitle("今日热闻");

        View view = layoutInflater.inflate(R.layout.fragment_main_news, viewGroup, false);
        lv_news = (ListView) view.findViewById(R.id.lv_news);

        View header = layoutInflater.inflate(R.layout.kanner, lv_news, false);
        kanner = (Kanner) header.findViewById(R.id.kanner);

        kanner.setOnItemClickListener(new Kanner.OnItemClickListener() {
            @Override
            public void click(View v, Latest.TopStoriesEntity entity) {
                Toast.makeText(mActivity, "点击了轮播控件", Toast.LENGTH_SHORT).show();
            }
        });

        lv_news.addHeaderView(header);
        mAdapter = new MainNewsItemAdapter(mActivity);
        lv_news.setAdapter(mAdapter);
        lv_news.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (lv_news != null && lv_news.getChildCount() > 0) {
                    // ??? ListView被滑动到最顶部
                    boolean enable = (firstVisibleItem == 0) && (absListView.getChildAt(firstVisibleItem).getTop() == 0);
                    ((MainActivity) mActivity).setSwipeRefreshEnable(enable);

                    if (firstVisibleItem + visibleItemCount == totalItemCount && !isLoading) {
                        loadMore(Constant.BEFORE + date);
                    }
                }
            }
        });

        lv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mActivity,"点击了列表",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // 加载更多
    private void loadMore(final String url) {
        isLoading = true;
        HttpUtils.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                before = gson.fromJson(responseString, Before.class);
                date = before.getDate();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<StoriesEntity> stories = before.getStories();

                        StoriesEntity topic = new StoriesEntity();
                        topic.setType(Constant.TOPIC);
                        topic.setTitle(convertDate(date));
                        stories.add(0, topic);

                        mAdapter.addList(stories);
                        isLoading = false;

                    }
                });

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        HttpUtils.get(Constant.LATEST, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(mActivity,"出错了！",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                latest = gson.fromJson(responseString, Latest.class);
                // 初始化date
                date = latest.getDate();
                kanner.setTopEntities(latest.getTop_stories());

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<StoriesEntity> stories = latest.getStories();

                        StoriesEntity topic = new StoriesEntity();
                        topic.setType(Constant.TOPIC);
                        topic.setTitle("今日新闻");
                        stories.add(0, topic);

                        // lv_news.setAdapter(new NewsItemAdapter(mActivity, stories));
                        mAdapter.addList(stories);
                        isLoading = false;

                    }
                });
            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    private String convertDate(String date) {
        String result = date.substring(0, 4);
        result += "年";
        result += date.substring(4, 6);
        result += "月";
        result += date.substring(6, 8);
        result += "日";
        return result;
    }
}














