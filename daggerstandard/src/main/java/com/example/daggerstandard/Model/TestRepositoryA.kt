package com.example.daggerstandard.Model

import android.util.Log

class TestRepositoryA {

    fun printMessage(){
        Log.d("NoDaggerCore",javaClass.canonicalName)
    }
}