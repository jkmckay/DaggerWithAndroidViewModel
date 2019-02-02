package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules
import com.example.jamesmckay.DaggerWithAndroidViewModel.View.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}