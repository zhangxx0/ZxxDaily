package com.xinxin.zxxdaily.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.xinxin.zxxdaily.R;
import com.xinxin.zxxdaily.util.Constant;
import com.xinxin.zxxdaily.util.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cz.msebera.android.httpclient.Header;

/**
 * 启动页面
 * 放大图片的动画
 */
public class SplashActivity extends Activity {

    private ImageView iv_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ???
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        iv_start = (ImageView) findViewById(R.id.iv_start);

        initImage();

    }

    // 放大图片动画方法
    private void initImage() {
        File dir = getFilesDir();
        final File imageFile = new File(dir, "start.jpg");
        if (imageFile.exists()) {
            iv_start.setImageBitmap(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));
        } else {
            iv_start.setImageResource(R.mipmap.start);
        }

        // 放大动画
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 动画结束
                // 获取并保存登录图片，并跳转到主页；
                // 首先判断网络是否可用
                if (HttpUtils.isNetworkConnected(SplashActivity.this)) {
                    HttpUtils.get(Constant.START, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            // 处理返回的图片url
                            // {"text":"© QJ键","img":"https:\/\/pic4.zhimg.com\/7a71f7868e74af3930ecea71dced8925.jpg"}
                            Log.d("+++", new String(responseBody));
                            try {
                                JSONObject imageObj = new JSONObject(new String(responseBody));
                                String imageUrl = imageObj.getString("img");
                                // 获取图片
                                // javax.net.ssl.SSLException: hostname in certificate didn't match: <pic4.zhimg.com> != <*.ucdl.pp.uc.cn> OR <*.ucdl.pp.uc.cn>
                                // 报错，未解决,算是解决了吧，
                                HttpUtils.getImage(imageUrl, new BinaryHttpResponseHandler() {
                                    @Override
                                    public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
                                        // 保存图片，跳转主页面
                                        saveImage(imageFile, binaryData);
                                        startMain();
                                    }

                                    @Override
                                    public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {
                                        Toast.makeText(SplashActivity.this,"获取图片失败！",Toast.LENGTH_SHORT).show();
                                        startMain();
                                    }
                                });

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            startMain();
                        }
                    });
                } else {
                    Toast.makeText(SplashActivity.this,"没有网络连接",Toast.LENGTH_SHORT).show();
                    startMain();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //
            }
        });

        iv_start.setAnimation(scaleAnimation);
    }

    // 启动主页面
    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // ???
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        finish();
    }

    // 保存图片
    public void saveImage(File file, byte[] bytes) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}










