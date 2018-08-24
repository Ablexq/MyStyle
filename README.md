

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

参考：

[给Activity设置背景（半）透明](https://blog.csdn.net/lu1024188315/article/details/78427058)

[Android Theme的使用](https://www.cnblogs.com/Jude95/p/4369816.html)

[如何在AndroidStudio中新建xml文件夹和values-21文件夹](https://blog.csdn.net/jxq1994/article/details/52737855)

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


Android系统在4.0之前没有设计可言，打开APP就是黑乎乎一片，这是最原始的Theme主题
在Android4.0有了Holo主题，Holo本身继承于Theme主题，而Holo.NoActionBar ，Holo.Dialog，Holo.Light这些都是衍生自Holo主题
在Android5.0有了Material主题，俗称材料主题，也是继承于Theme主题




Android 3.0                   11
Android 4.0                   14
Android 4.4                   19
Android 5.0                   21

values-sw600dp sw代表smallwidth的意思，当你的屏幕的绝对宽度大于600dp时，屏幕就会自动调用layout-sw600dp文件夹里面的布局。
values-w820dp表明这个目录下的资源所要求屏幕的最小宽度是820dp。
values-v11代表在API 11+的设备上，用该目录下的styles.xml代替res/values/styles.xml
values-v14代表在API 14+的设备上，用该目录下的styles.xml代替res/values/styles.xml
values-v19/style.xml—对应api19+手机型号在此调用。 
values-v21/style.xml—对应api21+手机型号在此调用。 
values/style.xml—对应上面中没有对应主题时默认在此调用。


ldpi(low) ~ 120dpi 
mdpi(medium) ~ 160dpi 
hdpi(high) ~ 240dpi 
xhdpi(extra-high) ~ 320dpi 
xxhdpi(extra-extra-high) ~ 480dpi 
xxxhpi(extra-extra-extra-high) ~ 640dpi


layout-sw600dp、layout-w600dp和layout-h600dp的区别~~
====

一、layout-sw600dp

这里的sw代表smallwidth的意思，当你的屏幕的绝对宽度大于600dp时，屏幕就会自动调用layout-sw600dp文件夹里面的布局。

注意：这里的【绝对宽度】是指手机的实际宽度，即与手机是否横屏没关系，也就是手机较小的边的长度。


二、layout-w600dp

当你的屏幕的相对宽度大于600dp时，屏幕就会自动调用layout-w600dp文件夹里面的布局。

注意：这里的【相对宽度】是指手机相对放置的宽度；即当手机竖屏时，为较小边的长度；当手机横屏时，为较长边的长度。


三、layout-h600dp

与layout-w600dp的使用一样，只是这里指的是相对的高度。

当你的屏幕的相对高度大于600dp时，屏幕就会自动调用layout-w600dp文件夹里面的布局。

注意：这里的相对高度是指手机相对放置的高度；即当手机竖屏时，为较长边的长度；
当手机横屏时，为较小边的长度。但这种方式很少使用，因为屏幕在相对高度上，
即在纵向上通常能够滚动导致长度变化，而不像横向那样基本固定，因而这个方法灵活性差，google官方文档建议尽量使用这种方式。


layout-sw600dp-land ： 横屏绝对宽度600dp以上可用
layout-sw720dp-port ： 竖屏绝对宽度600dp以上可用

land是横屏，port是竖屏。


参考：

[Android 目前最稳定和高效的UI适配方案](https://www.jianshu.com/p/a4b8e4c5d9b0)



宽高限定符适配与sw限定符适配区别：

=====

宽高限定符适配：values-1920x1080
===

穷举市面上所有的Android手机的宽高像素值

但是这个方案有一个致命的缺陷，那就是需要精准命中才能适配，比如1920x1080的手机就一定要找到1920x1080的限定符，
否则就只能用统一的默认的dimens文件了。而使用默认的尺寸的话，UI就很可能变形，简单说，就是容错机制很差。

smallestWidth适配 ：value-sw360dp
===

smallestWidth适配，或者叫sw限定符适配。指的是Android会识别屏幕可用高度和宽度的最小尺寸的dp值（其实就是手机的宽度值），
然后根据识别到的结果去资源文件中寻找对应限定符的文件夹下的资源文件。

这种机制和上文提到的宽高限定符适配原理上是一样的，都是系统通过特定的规则来选择对应的文件。

举个例子，小米5的dpi是480,横向像素是1080px，根据px=dp(dpi/160)，
横向的dp值是1080/(480/160),也就是360dp,系统就会去寻找是否存在value-sw360dp的文件夹以及对应的资源文件。

smallestWidth限定符适配 和 宽高限定符 适配最大的区别在于，
前者有很好的容错机制，如果没有value-sw360dp文件夹，系统会向下寻找，
比如离360dp最近的只有value-sw350dp，那么Android就会选择value-sw350dp文件夹下面的资源文件。
这个特性就完美的解决了上文提到的宽高限定符的容错问题。

相同缺陷：

那就是多个dimens文件可能导致apk变大，这是事实，
根据生成的dimens文件的覆盖范围和尺寸范围，apk可能会增大300kb-800kb左右，目前糗百的dimens文件大小是406kb


像素密度 : dpi = px / inch
通常 ： dpi = 宽px / 宽inch 或者 dpi = 高px / 高inch
严格 ： dpi = 斜对角px / 斜对角inch

px=dp(dpi/160)

iphone6 
750*1334px

huawei nova2
1080*1920 480dp/xxhpi/3.0x 













