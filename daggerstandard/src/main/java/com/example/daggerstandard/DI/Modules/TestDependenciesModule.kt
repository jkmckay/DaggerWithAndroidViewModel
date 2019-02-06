package com.example.daggerstandard.DI.Modules

import com.example.daggerstandard.Model.TestRepositoryA
import com.example.daggerstandard.Model.TestRepositoryB
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