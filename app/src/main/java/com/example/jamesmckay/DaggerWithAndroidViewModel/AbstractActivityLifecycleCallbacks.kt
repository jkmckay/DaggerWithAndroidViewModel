package com.example.jamesmckay.DaggerWithAndroidViewModel

import android.app.Activity
import android.app.Application
import android.os.Bundle


/**
 * Purpose of this class is to remove boilerplate code & streamline
 * our implementation of Google's LifeCycle-aware components
 */
//In addition this assists in minimizing Dagger's ActivityInjection boilerplate.
abstract class AbstractActivityLifecycleCallbacks: Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }
}