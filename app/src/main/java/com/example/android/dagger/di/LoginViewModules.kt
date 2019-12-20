package com.example.android.dagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.dagger.login.LoginViewModel
import com.example.android.dagger.registration.RegistrationViewModel
import com.example.android.dagger.registration.enterdetails.EnterDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module()
abstract class LoginViewModules {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun provideLoginViewModel(weatherViewModel: LoginViewModel): ViewModel

    @ActivityScope
    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}