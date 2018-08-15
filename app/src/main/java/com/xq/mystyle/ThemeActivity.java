package com.xq.mystyle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.WindowManager;


public class ThemeActivity extends FragmentActivity {

    @Override
    protected void onStart() {
        super.onStart();

        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.height = (int) (d.getHeight() * 0.5);   //ContentView高度设置
        p.width = (int) (d.getWidth() * 0.5);    //ContentView宽度设置
        p.alpha = 0.8f;                     //设置 ContentView 本身的透明度:【0透明,1不透明】
        p.dimAmount = 0.8f;                 //设置 ContentView 之外的透明度:【0透明,1不透明】
        getWindow().setAttributes(p);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
    }
}
