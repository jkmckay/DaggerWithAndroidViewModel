package com.example.daggerstandard.ViewModels

import androidx.lifecycle.ViewModel
import com.example.daggerstandard.Model.TestRepositoryA
import com.example.daggerstandard.Model.TestRepositoryB
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dependencyA: TestRepositoryA, private val dependencyB: TestRepositoryB): ViewModel(){


fun getMessages(){
    dependencyA.printMessage()
    dependencyB.printMessage()
}

}