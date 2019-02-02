package com.example.jamesmckay.DaggerWithAndroidViewModel

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.components.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DaggerWithAndroidViewModelApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        initializeDependencyInjection()
        super.onCreate()

    }
    //dispatchingAndroidInjector for the app's activities.
    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }


    private fun initializeDependencyInjection() {
        // instantiate Dagger & inject app class.
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        registerActivityLifecycleCallbacks(object : AbstractActivityLifecycleCallbacks() {
            //        on activity created inject this activity with its dependencies
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
      //                if (activity is HasSupportFragmentInjector) {
                    AndroidInjection.inject(activity)

//                }

            }
        })
    }
}