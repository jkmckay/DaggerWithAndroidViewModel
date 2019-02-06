package com.example.daggercore.DI.components

import com.example.daggercore.DI.Modules.ActivityModule
import com.example.daggercore.DI.Modules.AppModule
import com.example.daggercore.DaggerCore
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

interface AppComponent: AndroidInjector<DaggerCore> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerCore>()
}
