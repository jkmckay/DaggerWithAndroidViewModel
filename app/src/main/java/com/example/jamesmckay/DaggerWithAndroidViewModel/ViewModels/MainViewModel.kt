package com.example.jamesmckay.DaggerWithAndroidViewModel.ViewModels

import androidx.lifecycle.ViewModel
import com.example.jamesmckay.DaggerWithAndroidViewModel.Model.TestRepositoryA
import com.example.jamesmckay.DaggerWithAndroidViewModel.Model.TestRepositoryB
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dependencyA: TestRepositoryA, private val dependencyB: TestRepositoryB): ViewModel(){


fun getMessages(){
    dependencyA.printMessage()
    dependencyB.printMessage()
}

}