

[Android5.0常用颜色属性说明](https://blog.csdn.net/u012702547/article/details/50932090)

[Android状态栏微技巧，带你真正理解沉浸式模式](https://blog.csdn.net/guolin_blog/article/details/51763825)

[Android DecorView浅析](https://www.cnblogs.com/ldq2016/p/6671501.html)

```
applicaton
	activity
		window
			decorview
				linearlayout
					viewstub(actionbar)
					framelayout(content区域)
						用户自定义
				view(navigationbar)
				view(statusbar)
```


sdk 中 uiautomatorviewer 工具的使用：
===

使用了style/Theme.AppCompat.Light.NoActionBar
![](https://github.com/Ablexq/MyStyle/blob/master/pics/%E5%8E%BB%E6%8E%89actionBar.png)

未使用style/Theme.AppCompat.Light.NoActionBar

![](https://github.com/Ablexq/MyStyle/blob/master/pics/%E5%B8%A6actionBar.png)


沉浸式：
===

```

@Override
public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus && Build.VERSION.SDK_INT >= 19) {
        //Android 4.4及以上系统才支持沉浸式模式
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}

```







