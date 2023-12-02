package id.mzennis.toktik.login.di

import dagger.Component
import id.mzennis.toktik.common.di.ApplicationComponent
import id.mzennis.toktik.login.LoginActivity

@LoginScope
@Component(
    modules = [LoginModule::class],
    dependencies = [ApplicationComponent::class]
)
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}