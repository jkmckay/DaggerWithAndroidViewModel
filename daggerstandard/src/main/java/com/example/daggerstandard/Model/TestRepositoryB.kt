package com.example.daggerstandard.Model

import android.util.Log
import javax.inject.Inject

class TestRepositoryB @Inject constructor() {

    fun printMessage() {
        Log.d("NoDaggerCore", javaClass.canonicalName)
    }
}