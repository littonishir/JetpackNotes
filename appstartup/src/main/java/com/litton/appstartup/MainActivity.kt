package com.litton.appstartup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.startup.AppInitializer
import com.litton.appstartup.initializer.SpiderManInit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                R.id.mButton1 -> {
                    var a = 12 / 0
                }
                R.id.mButton2 -> {
                    AppInitializer.getInstance(this).initializeComponent(SpiderManInit::class.java)
                    Toast.makeText(this, "初始化完成", Toast.LENGTH_SHORT).show()
                }
                else -> {
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButton1.setOnClickListener(this)
        mButton2.setOnClickListener(this)
    }
}
