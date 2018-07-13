package com.xq.mystyle;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.xq.mystyle.utils.StatusBarUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTv1 = ((TextView) this.findViewById(R.id.tv1));
        TextView mTv2 = ((TextView) this.findViewById(R.id.tv2));
        TextView mTv3 = ((TextView) this.findViewById(R.id.tv3));
        TextView mTv4 = ((TextView) this.findViewById(R.id.tv4));
        TextView mTv5 = ((TextView) this.findViewById(R.id.tv5));
        TextView mTv6 = ((TextView) this.findViewById(R.id.tv6));
        mTv1.setOnClickListener(this);
        mTv2.setOnClickListener(this);
        mTv3.setOnClickListener(this);
        mTv4.setOnClickListener(this);
        mTv5.setOnClickListener(this);
        mTv6.setOnClickListener(this);

        int statusBarHeight = StatusBarUtils.getStatusBarHeight(this);
        System.out.println("statusBarHeight=========" + statusBarHeight);//72
        boolean hasNavigationBar = StatusBarUtils.checkDeviceHasNavigationBar(this);
        System.out.println("hasNavigationBar========" + hasNavigationBar);
        if (hasNavigationBar) {
            int navigationBarHeight = StatusBarUtils.getNavigationBarHeight(this);
            System.out.println("navigationBarHeight=========" + navigationBarHeight);//132
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*--------------------------------以下四种未占用状态栏------------------------------*/
            case R.id.tv1:
                StatusBarUtils.setStatusBar(this, false, false);//透明底、黑字
                break;

            case R.id.tv2:
                StatusBarUtils.setStatusBar(this, true, false);//指定色底、黑字
                break;

            case R.id.tv3:
                StatusBarUtils.setStatusBar(this, false, true);//透明底、白字
                break;

            case R.id.tv4:
                StatusBarUtils.setStatusBar(this, true, true);//指定色底、白字
                break;
            /*--------------------------------------------------------------------------------*/

            case R.id.tv5://移动到状态栏下面，并设置状态栏背景透明
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                break;

            case R.id.tv6://直接隐藏状态栏
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    View decorView = getWindow().getDecorView();
                    //SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思，也就是会将状态栏隐藏。
                    int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
                    decorView.setSystemUiVisibility(option);
                }
                break;
        }
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            //Android 4.4及以上系统才支持沉浸式模式
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }
}






















