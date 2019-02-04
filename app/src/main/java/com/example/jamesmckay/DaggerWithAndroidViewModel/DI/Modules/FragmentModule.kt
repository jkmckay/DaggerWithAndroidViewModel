package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules

import com.example.jamesmckay.DaggerWithAndroidViewModel.View.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

//While TestFragment is not used in this project, it is included for completeness.
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeTestFragment(): TestFragment
}