package id.mzennis.toktik.common.di

import dagger.Component
import id.mzennis.toktik.common.UserSession
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun userSession(): UserSession
}