package com.xinxin.zxxdaily.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.xinxin.zxxdaily.R;
import com.xinxin.zxxdaily.adapter.NewsTypeAdapter;
import com.xinxin.zxxdaily.model.NewsListItem;
import com.xinxin.zxxdaily.util.Constant;
import com.xinxin.zxxdaily.util.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xinxin on 2016/2/27.
 * 侧滑菜单碎片
 */
public class MenuFragment extends Fragment implements View.OnClickListener {

    private ListView lv_item;
    private TextView tv_download, tv_main;

    //     private static String[] ITEMS = { "日常心理学", "用户推荐日报", "电影日报", "不许无聊",
//        "设计日报", "大公司日报", "财经日报", "互联网安全", "开始游戏", "音乐日报", "动漫日报", "体育日报" };
    private List<NewsListItem> items;
    private Handler handler = new Handler();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        tv_download = (TextView) view.findViewById(R.id.tv_download);
        tv_main = (TextView) view.findViewById(R.id.tv_main);
        lv_item = (ListView) view.findViewById(R.id.lv_item);
        tv_download.setOnClickListener(this);
        tv_main.setOnClickListener(this);

        getItems();

        return view;
    }

    // 初始化列表
    private void getItems() {
        // 常量测试通过
        // lv_item.setAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,ITEMS));
        items = new ArrayList<NewsListItem>();
        // 获取themes
        HttpUtils.get(Constant.THEMES, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    JSONArray themesArr = response.getJSONArray("others");
                    for (int i = 0; i < themesArr.length(); i++) {
                        NewsListItem item = new NewsListItem();
                        JSONObject theme = themesArr.getJSONObject(i);
                        item.setTitle(theme.getString("name"));
                        item.setId(theme.getString("id"));
                        items.add(item);
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            lv_item.setAdapter(new NewsTypeAdapter(getActivity(),items));
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_main:
                break;
            case R.id.tv_download:
                break;
            default:
                break;
        }

    }
}
