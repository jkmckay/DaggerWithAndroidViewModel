package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules
import com.example.jamesmckay.DaggerWithAndroidViewModel.View.MainActivity
import com.example.jamesmckay.DaggerWithAndroidViewModel.ViewModels.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [(FragmentModule::class)])
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}