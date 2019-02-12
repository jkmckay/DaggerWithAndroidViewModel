package com.example.daggercore.DI.Modules

import com.example.daggercore.Model.TestRepositoryA
import com.example.daggercore.Model.TestRepositoryB
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