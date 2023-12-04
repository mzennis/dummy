package id.mzennis.toktik.common.di

import dagger.Component
import id.mzennis.toktik.common.Session
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun userSession(): Session // define methods to access the application-scoped object
}