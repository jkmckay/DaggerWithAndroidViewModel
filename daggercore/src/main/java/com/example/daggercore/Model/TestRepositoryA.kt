package com.example.daggercore.Model

import android.util.Log
import javax.inject.Inject

class TestRepositoryA @Inject constructor() {

    fun printMessage(){
        Log.d("DaggerCore",javaClass.canonicalName)
    }
}