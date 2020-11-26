# App Startup



[developer.android.google](https://developer.android.google.cn/topic/libraries/app-startup)

#### 1. 添加依赖

```groovy
dependencies {
    implementation "androidx.startup:startup-runtime:1.0.0"
}
```

#### 2. 实现组件初始化器

Initializer返回值需要就返回不需要就返回Unit。

```kotlin
class AutoSizeInit : Initializer<Unit> {
    override fun create(context: Context) {
        AutoSizeConfig.getInstance().unitsManager.setSupportDP(false).supportSubunits = Subunits.MM
        Log.e("Initializer", "AutoSizeInit create")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return emptyList<Class<Initializer<*>>>().toMutableList()
    }
}
```

```kotlin
class SpiderManInit : Initializer<SpiderMan> {
    override fun create(context: Context): SpiderMan {
        Log.e("Initializer", "AutoSizeInit create")
        return SpiderMan.init(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return emptyList<Class<Initializer<*>>>().toMutableList()
    }
}
```



#### 3. 设置清单条目

android:name这里填写的是 自己实现Initializer类的路径。其他属性不要动！

tools:node="remove" 这里表示App Startup 初始化的时候不初始化需要自己手动调用初始化方法。

```xml
<provider
    android:name="androidx.startup.InitializationProvider"
    android:authorities="${applicationId}.androidx-startup"
    android:exported="false"
    tools:node="merge">
    <meta-data
        android:name="com.litton.appstartup.initializer.AutoSizeInit"
        android:value="androidx.startup" />
    <meta-data
        android:name="com.litton.appstartup.initializer.SpiderManInit"
        android:value="androidx.startup"
        tools:node="remove"/>
</provider>
```

手动调用初始化方法

```kotlin
AppInitializer.getInstance(this).initializeComponent(SpiderManInit::class.java)
```


