package com.example.daggerstandard.DI.Modules

import com.example.daggerstandard.View.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

//While TestFragment is not used in this project, it is included for completeness.
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeTestFragment(): TestFragment
}