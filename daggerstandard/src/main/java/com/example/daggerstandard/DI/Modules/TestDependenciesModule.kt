package com.example.daggerstandard.DI.Modules

import com.example.daggerstandard.Model.TestRepositoryA
import com.example.daggerstandard.Model.TestRepositoryB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestDependenciesModule{

    @Singleton
    @Provides
    @JvmStatic
    fun provideTestRepoA(): TestRepositoryA = TestRepositoryA()

    @Singleton
    @Provides
    @JvmStatic
    fun provideTestRepoB(): TestRepositoryB = TestRepositoryB()

}