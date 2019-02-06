package com.example.daggercore.DI.Modules
import com.example.daggercore.View.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [(FragmentModule::class)])
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}