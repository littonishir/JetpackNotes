package com.litton.appstartup.initializer

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits

class AutoSizeInit : Initializer<Unit> {
    override fun create(context: Context) {
        AutoSizeConfig.getInstance().unitsManager.setSupportDP(false).supportSubunits = Subunits.MM
        Log.e("Initializer", "AutoSizeInit create")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return emptyList<Class<Initializer<*>>>().toMutableList()
    }
}