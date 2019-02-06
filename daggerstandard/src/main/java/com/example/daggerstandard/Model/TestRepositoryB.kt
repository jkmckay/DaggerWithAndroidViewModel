package com.example.daggerstandard.Model

import android.util.Log

class TestRepositoryB {

    fun printMessage(){
        Log.d("NoDaggerCore",javaClass.canonicalName)
    }
}