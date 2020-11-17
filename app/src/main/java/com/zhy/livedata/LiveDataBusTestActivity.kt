package com.zhy.livedata

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zhy.livedata.databus.LiveDataBus

class LiveDataBusTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata_bus)

        LiveDataBus.instance
            .with("data", String::class.java).observe(this, {
                Toast.makeText(baseContext, it, Toast.LENGTH_SHORT).show()
            })
    }
}