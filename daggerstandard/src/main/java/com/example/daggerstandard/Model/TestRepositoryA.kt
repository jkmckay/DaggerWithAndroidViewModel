package com.example.daggerstandard.Model

import android.util.Log
import javax.inject.Inject

class TestRepositoryA @Inject constructor() {

    fun printMessage() {
        Log.d("NoDaggerCore", javaClass.canonicalName)
    }
}