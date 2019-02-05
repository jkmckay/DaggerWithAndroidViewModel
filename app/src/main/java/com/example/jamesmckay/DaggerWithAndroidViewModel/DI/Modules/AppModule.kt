package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, TestDependenciesModule::class])

class AppModule {
// ApplicationContext is not required for this project, this is here just as an example.
    @Singleton
    @Provides
    fun provideApplicationContext(app: DaggerApplication): Context {
        return app.applicationContext
    }
}