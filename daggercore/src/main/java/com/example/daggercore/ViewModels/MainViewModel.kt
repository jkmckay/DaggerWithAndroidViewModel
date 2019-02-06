package com.example.daggercore.ViewModels

import androidx.lifecycle.ViewModel
import com.example.daggercore.Model.TestRepositoryA
import com.example.daggercore.Model.TestRepositoryB
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dependencyA: TestRepositoryA, private val dependencyB: TestRepositoryB): ViewModel(){


fun getMessages(){
    dependencyA.printMessage()
    dependencyB.printMessage()
}

}