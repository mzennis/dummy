package id.mzennis.toktik.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun loginComponent(): LoginComponent

    fun mainComponent(): MainComponent
}