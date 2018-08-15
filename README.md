

[Android5.0常用颜色属性说明](https://blog.csdn.net/u012702547/article/details/50932090)

[Android状态栏微技巧，带你真正理解沉浸式模式](https://blog.csdn.net/guolin_blog/article/details/51763825)

[Android DecorView浅析](https://www.cnblogs.com/ldq2016/p/6671501.html)

[Android 5.0以上系统常用控件着色指南](https://blog.csdn.net/jiashuai94/article/details/79280415)

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


代码中去掉背景：
===

```
1.setBackgroundResource(0);

2.setBackgroundColor(0);
```

设置背景白色：
====

1、根布局:
```
android:background="#ffffff"
```

2、theme:
```
@android:style/Theme.Light //背景白色-有标题-非全屏
@android:style/Theme.Light.NoTitleBar //背景白色-无标题-非全屏
@android:style/Theme.Light.NoTitleBar.Fullscreen //背景白色-无标题-全屏显示
```


设置背景透明：
====

1、根布局
```
android:background="#00000000"  
```

2、theme:
```
@android:style/Theme.Translucent
```

3、设置
```
<color name="transparent">#00000000</color>  
```

```
<style name="Transparent">
    <item name="android:windowBackground">@color/transparent</item>
    <item name="android:windowIsTranslucent">true</item>
    <item name="android:windowNoTitle">true</item>
    <item name="android:windowAnimationStyle">@android:style/Animation.Translucent</item>
</style>
```
引用：
```
android:theme="@style/Transparent"  

```


```
系统自带主题：
API 1:
android:Theme 根主题
android:Theme.Black 背景黑色
android:Theme.Light 背景白色
android:Theme.Wallpaper 以桌面墙纸为背景
android:Theme.Translucent 透明背景
android:Theme.Panel 平板风格
android:Theme.Dialog 对话框风格

API 11:
android:Theme.Holo Holo根主题
android:Theme.Holo.Black Holo黑主题
android:Theme.Holo.Light Holo白主题

API 14:
Theme.DeviceDefault 设备默认根主题
Theme.DeviceDefault.Black 设备默认黑主题
Theme.DeviceDefault.Light 设备默认白主题

API 21: (网上常说的 Android Material Design 就是要用这种主题)
Theme.Material Material根主题
Theme.Material.Light Material白主题


兼容包v7中带的主题：
Theme.AppCompat 兼容主题的根主题
Theme.AppCompat.Black 兼容主题的黑色主题
Theme.AppCompat.Light 兼容主题的白色主题
```


Black 黑色风格
Light 光明风格
Dark 黑暗风格
DayNight 白昼风格
Wallpaper 墙纸为背景
Translucent 透明背景
Panel 平板风格
Dialog 对话框风格
NoTitleBar 没有TitleBar
NoActionBar 没有ActionBar
Fullscreen 全屏风格
MinWidth 对话框或者ActionBar的宽度根据内容变化，而不是充满全屏
WhenLarge 对话框充满全屏
TranslucentDecor 半透明风格
NoDisplay 不显示，也就是隐藏了
WithActionBar 在旧版主题上显示ActionBar

很多主题在使用时会报错，原因有很多，
比如窗体必须继承AppCompactActivity，
或者要继承ActionBarActiivty，
或者要继承FragmentActivity，
或者需要手动指定宽高，
或者需要提升最低API版本，
或者需要更高版本的SDK，
或者兼容包版本不对等原因。

比如：
你的Activity继承的是V7包的AppCompatActivity，这时你所使用的主题要与Theme.AppCompat兼容，否则程序就会崩溃了。

参考：[给Activity设置背景（半）透明](https://blog.csdn.net/lu1024188315/article/details/78427058)
参考：[Android Theme的使用](https://www.cnblogs.com/Jude95/p/4369816.html)


```
<!-- 兼容主题 深色主题 activity背景默认黑色，字体默认白色-->
<style name="AppTheme" parent="Theme.AppCompat">
</style>

<!-- 兼容主题 浅色主题 activity背景默认白色 字体默认黑色 -->
<style name="AppTheme2" parent="Theme.AppCompat.Light">
</style>

<!-- 兼容主题 深色主题 无Actionbar-->
<style name="AppTheme3" parent="Theme.AppCompat.NoActionBar">
</style>

<!-- 兼容主题 浅色主题 无Actionbar-->
<style name="AppTheme4" parent="Theme.AppCompat.Light.NoActionBar">
</style>

```

如果使用 android.support.v7.app.ActionBarActivity 就必须要用兼容主题Theme.AppCompat。

ActionBarActivity 的存在就是为了兼容低API。让他们用上高API的东西。比如Toolbar。



