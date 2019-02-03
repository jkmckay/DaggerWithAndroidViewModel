package com.example.jamesmckay.DaggerWithAndroidViewModel

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.jamesmckay.DaggerWithAndroidViewModel.DI.components.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
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
            //       when 'onActivityCreated' is called; inject this activity with its dependencies
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                /*
                Check to see if the Activity has implemented HasSupportFragmentInjector so that any fragments
                may have their dependencies provided. Although this check is unnecessary for this project at this stage,
                it is here purely as an example.
                 */
                if (activity is HasSupportFragmentInjector) {
                    AndroidInjection.inject(activity)
                }
                //injects fragment in question's dependencies when onFragmentCreated is called.
                (activity as AppCompatActivity).supportFragmentManager.registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                                AndroidSupportInjection.inject(f)
                        }
                    }, true
                )

            }
        })
    }
}