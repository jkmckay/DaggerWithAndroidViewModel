package com.example.daggercore.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

//This ViewModelFactory is a requirement for AndroidViewModels that require any parameters.
@Singleton
class ViewModelFactory @Inject constructor(
    //creators -> a map of Class extending ViewModel & Provider of viewModel
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {
/*
    modelClass -> param of type Class of type `T`.
    return value: T -> a mutable returned generic type T that extends/implements ViewModel.
*/
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val foundViewModel = creators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator = foundViewModel?.value
            ?: throw IllegalArgumentException("unknown model class " + modelClass)
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}

