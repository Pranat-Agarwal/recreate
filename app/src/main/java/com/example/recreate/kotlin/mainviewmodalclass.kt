package com.example.recreate.kotlin

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData

class mainviewmodalclass
{
    var tag = mainviewmodalclass::class.java.simpleName
    var count =0
    var seconds= MutableLiveData<Int>()
    fun increamentcount(){
        count++
    }
    fun starttimer(){
        var timer = object : CountDownTimer(10_100,1_000){
            override fun onTick(millisUntilFinished: Long) {
                Log.i(tag,""+millisUntilFinished)
                seconds.value = millisUntilFinished.toInt()
            }

            override fun onFinish() {
                Log.i(tag,"timercompleted")
            }
        }.start()
    }
}