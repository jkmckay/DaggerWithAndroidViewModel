package com.example.jamesmckay.DaggerWithAndroidViewModel.ViewModels

import androidx.lifecycle.ViewModel
import com.example.jamesmckay.DaggerWithAndroidViewModel.Model.TestRepositoryA
import com.example.jamesmckay.DaggerWithAndroidViewModel.Model.TestRepositoryB
import javax.inject.Inject

class MainViewModel @Inject constructor(val dependencyA: TestRepositoryA, val dependencyB: TestRepositoryB): ViewModel(){


fun getMessages(){
    dependencyA.printMessage()
    dependencyB.printMessage()
}

}