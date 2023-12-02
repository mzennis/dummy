package id.mzennis.toktik.common.di

import dagger.Component
import id.mzennis.toktik.common.UserSession
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {
    fun userSession(): UserSession // define methods to access the application-scoped object
}