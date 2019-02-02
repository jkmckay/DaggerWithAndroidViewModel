package com.example.jamesmckay.DaggerWithAndroidViewModel.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    //creators -> a map of Class extending ViewModel & Provider of viewModel
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

/*
    modelClass -> param of type Class of type `T`.
    return value: T -> a mutable returned generic type T that extends/implements ViewModel.
*/
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        val foundViewModel = creators.entries.find { modelClass.isAssignableFrom(it.key) }
//        val creator = foundViewModel?.value
//            ?: throw IllegalArgumentException("unknown model class " + modelClass)
//        try {
//            @Suppress("UNCHECKED_CAST")
//            return creator.get() as T
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//    }



    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        /** creator = ViewModelProvider that is of the specified modelClass type **/
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        /** Rest is errorResponse handling. **/
        if (creator == null) {
            throw IllegalArgumentException("unknown model class $modelClass")
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}

