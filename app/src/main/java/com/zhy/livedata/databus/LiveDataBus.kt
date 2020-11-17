package com.zhy.livedata.databus

import androidx.lifecycle.MutableLiveData

class LiveDataBus private constructor() {
    companion object {
        val instance: LiveDataBus by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LiveDataBus()
        }
    }
    //存放订阅者
    private val bus: MutableMap<String, MutableLiveData<Object>> = mutableMapOf()

    //注册订阅者
    @Synchronized
    fun <T> with(key: String, type: Class<T>): MutableLiveData<T> {
        if (!bus.containsKey(key)) {
            bus[key] = MutableLiveData();
        }
        return bus[key] as MutableLiveData<T>
    }
}