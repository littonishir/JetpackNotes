package com.litton.appstartup.initializer

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.simple.spiderman.SpiderMan

class SpiderManInit : Initializer<SpiderMan> {
    override fun create(context: Context): SpiderMan {
        Log.e("Initializer", "AutoSizeInit create")
        return SpiderMan.init(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return emptyList<Class<Initializer<*>>>().toMutableList()
    }
}