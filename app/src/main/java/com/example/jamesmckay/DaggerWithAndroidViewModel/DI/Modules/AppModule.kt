package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [ViewModelModule::class, TestDependenciesModule::class
    ]
)

class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(app: Application): Context {
        return app.applicationContext
    }
}