package com.xinxin.zxxdaily.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 * Created by xinxin on 2016/2/27.
 * 网络工具类
 */
public class HttpUtils {

    private static AsyncHttpClient client = new AsyncHttpClient();

    // true, 80, 443
    // 添加以上三个参数之后，可绕过 SSL 证书验证？ http://stackoverflow.com/questions/21833804/how-to-make-https-calls-using-asynchttpclient
    private static AsyncHttpClient client2 = new AsyncHttpClient(true, 80, 443);

    /**
     * get方法
     */
    public static void get(String url, ResponseHandlerInterface responseHandlerInterface) {
        client.get(Constant.BASEURL+url, responseHandlerInterface);
    }

    /**
     * 获取图片方法
     */
    public static void getImage(String url,ResponseHandlerInterface responseHandlerInterface) {
        client.get(url, responseHandlerInterface);
    }

    /**
     * 判断网络是否可用
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
}
