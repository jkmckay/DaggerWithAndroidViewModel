package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.components

import android.app.Application
import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules.ActivityModule
import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules.AppModule
import com.example.jamesmckay.DaggerWithAndroidViewModel.DaggerWithAndroidViewModelApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class
    ]
)

interface AppComponent {
    /*
       @Component.Builder annotation allows one to specify a interface to be built as a component via its generated builder.
        There are a few ways of going about this. Cmd+click to read about its rules.
     */
    @Component.Builder
    interface Builder {
        /*
        @BindsInstance annotation allows a method belonging to a '@Component.Builder' annotated interface to bind an instance to a type within the component.
        Which in this case means that we can bind an instance of 'Application' to this builder. this instance can then be injected within the component.
         */
        @BindsInstance
        fun application(app: Application): Builder //pass application to app component.
        fun build(): AppComponent
    }
    //passes app instance and provides the app's and any of its members' dependencies via the dispatchingAndroidInjector.
    fun inject(app: DaggerWithAndroidViewModelApp)
}

