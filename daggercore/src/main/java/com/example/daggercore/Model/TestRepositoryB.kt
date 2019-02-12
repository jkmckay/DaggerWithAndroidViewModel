package com.example.daggercore.Model

import android.util.Log
import javax.inject.Inject

class TestRepositoryB @Inject constructor() {

    fun printMessage() {
        Log.d("DaggerCore", javaClass.canonicalName)
    }
}