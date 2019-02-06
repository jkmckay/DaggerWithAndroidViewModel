package com.example.daggerstandard.DI.Modules
import com.example.daggerstandard.View.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [(FragmentModule::class)])
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}