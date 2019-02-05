package com.example.jamesmckay.DaggerWithAndroidViewModel

import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class DaggerWithAndroidViewModelApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerAppComponent.builder().create(this)
    }

}