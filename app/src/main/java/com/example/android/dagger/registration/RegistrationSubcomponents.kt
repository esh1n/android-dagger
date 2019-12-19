package com.example.android.dagger.registration


import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.user.UserComponent
import dagger.Module

// This module tells a Component which are its subcomponents
@Module(subcomponents = [EnterDetailsComponent::class])
class RegistrationSubcomponents