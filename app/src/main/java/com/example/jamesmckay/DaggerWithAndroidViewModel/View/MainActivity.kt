package com.example.jamesmckay.DaggerWithAndroidViewModel.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import com.example.jamesmckay.DaggerWithAndroidViewModel.R
import com.example.jamesmckay.DaggerWithAndroidViewModel.ViewModels.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =  ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

    }

     override fun onResume() {
        super.onResume()
         viewModel.getMessages()
    }
}
