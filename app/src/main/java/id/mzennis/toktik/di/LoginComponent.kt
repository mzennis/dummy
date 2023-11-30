package id.mzennis.toktik.di

import dagger.Subcomponent
import id.mzennis.toktik.ui.login.LoginActivity

@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}