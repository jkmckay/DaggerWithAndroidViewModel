package com.example.daggercore.DI.Modules

import com.example.daggercore.Model.TestRepositoryA
import com.example.daggercore.Model.TestRepositoryB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestDependenciesModule{

    @Singleton
    @Provides
     fun provideTestRepoA(): TestRepositoryA = TestRepositoryA()

    @Singleton
    @Provides
     fun provideTestRepoB(): TestRepositoryB = TestRepositoryB()

}