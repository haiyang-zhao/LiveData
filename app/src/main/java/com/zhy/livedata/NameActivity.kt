package com.zhy.livedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class NameActivity : AppCompatActivity() {


    //Use the 'by viewModels()' Kotlin property delegate
    //from the activity-ktx artifact
    private val model: NameViewModel by viewModels()

    private var i: Int = 0
    private lateinit var tvText: TextView
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        tvText = findViewById(R.id.tvText)
        btn = findViewById(R.id.btn)

        val nameObserver = Observer<String> { newName ->
            //update UI
            tvText.text = newName

        }

        //Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)

        btn.setOnClickListener {
            i++
            model.currentName.setValue("click $i")
        }
    }
}