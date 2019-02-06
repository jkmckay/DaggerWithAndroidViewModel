package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.components

import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules.ActivityModule
import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules.AppModule
import com.example.jamesmckay.DaggerWithAndroidViewModel.DaggerWithAndroidViewModelApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class
    ]
)

interface AppComponent: AndroidInjector<DaggerWithAndroidViewModelApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerWithAndroidViewModelApp>()
}
