package com.example.android.dagger.registration

import com.example.android.dagger.di.FragmentScope
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import dagger.Subcomponent

@FragmentScope
// Definition of a Dagger subcomponent
@Subcomponent
interface EnterDetailsComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): EnterDetailsComponent
    }

    // Classes that can be injected by this Component
    fun inject(fragment: EnterDetailsFragment)

}