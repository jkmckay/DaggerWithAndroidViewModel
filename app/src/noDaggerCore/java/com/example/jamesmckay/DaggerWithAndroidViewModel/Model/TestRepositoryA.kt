package com.example.jamesmckay.DaggerWithAndroidViewModel.Model

import android.util.Log

class TestRepositoryA {

    fun printMessage(){
        Log.d("NoDaggerCore",javaClass.canonicalName)
    }
}