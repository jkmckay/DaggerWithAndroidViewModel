package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jamesmckay.DaggerWithAndroidViewModel.ViewModels.MainViewModel
import com.example.jamesmckay.DaggerWithAndroidViewModel.ViewModels.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    /*
    Binds is a replacement for `@Provides`. You use @Binds instead of provides
    when you do not need to specify the exact implementation.
    The Binds method can only have a single parameter whose type is assignable to the return type.
     */
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}

@MapKey
//TODO: Explain mapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)