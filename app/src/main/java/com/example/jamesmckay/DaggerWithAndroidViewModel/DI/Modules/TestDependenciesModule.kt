package com.example.jamesmckay.DaggerWithAndroidViewModel.DI.Modules

import com.example.jamesmckay.DaggerWithAndroidViewModel.Model.TestRepositoryA
import com.example.jamesmckay.DaggerWithAndroidViewModel.Model.TestRepositoryB
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