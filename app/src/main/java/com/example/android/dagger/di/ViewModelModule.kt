package com.example.android.dagger.di

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.dagger.registration.RegistrationViewModel
import com.example.android.dagger.registration.enterdetails.EnterDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Module()
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EnterDetailsViewModel::class)
    abstract fun provideBaseMLHViewModel(weatherViewModel: EnterDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    abstract fun provideRegistrationViewModel(weatherViewModel: RegistrationViewModel): ViewModel

    @ActivityScope
    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Suppress("UNCHECKED_CAST")
    class ViewModelFactory @Inject
    constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

        @NonNull
        override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
            var creator: Provider<out ViewModel>? = creators[modelClass]
            if (creator == null) {
                for ((key, value) in creators) {
                    if (modelClass.isAssignableFrom(key)) {
                        creator = value
                        break
                    }
                }
            }
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
}