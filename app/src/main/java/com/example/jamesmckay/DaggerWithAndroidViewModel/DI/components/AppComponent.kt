package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.components

import android.app.Application
import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules.ActivityBuilderModule
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
        ActivityBuilderModule::class
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
        fun application(app: Application): Builder
        fun build(): AppComponent

        /*
        Normally you can instantiate your component with `DaggerYourComponent.create()`
        But now that your component has modules, you'll need to call this builder instead.
         */
    }

    //class that needs the dependencies
    fun inject(app: DaggerWithAndroidViewModelApp)
}

