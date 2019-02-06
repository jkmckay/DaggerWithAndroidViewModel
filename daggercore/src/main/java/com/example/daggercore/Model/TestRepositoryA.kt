package com.example.daggercore.Model

import android.util.Log

class TestRepositoryA {

    fun printMessage(){
        Log.d("DaggerCore",javaClass.canonicalName)
    }
}