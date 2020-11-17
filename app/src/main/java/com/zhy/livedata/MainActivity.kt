package com.zhy.livedata

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zhy.livedata.databus.LiveDataBus

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun click(view: View) {
        when (view.id) {
            R.id.btn -> {
                startActivity(Intent(this, NameActivity::class.java))
            }
            R.id.btn2 -> {
                Handler().postDelayed({
                    startActivity(Intent(this, LiveDataBusTestActivity::class.java))
                }, 5000)

                Thread {
                    (0..10).forEach {
                        LiveDataBus.instance
                            .with("data", String::class.java).postValue("hello $it")
                        SystemClock.sleep(1000)
                    }
                }.start()
            }
        }
    }
}