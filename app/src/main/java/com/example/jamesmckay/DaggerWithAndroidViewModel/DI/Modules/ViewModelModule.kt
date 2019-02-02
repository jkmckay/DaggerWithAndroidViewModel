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

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}

@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)