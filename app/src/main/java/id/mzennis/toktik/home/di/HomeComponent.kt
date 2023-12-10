package id.mzennis.toktik.home.di

import dagger.Component
import id.mzennis.toktik.home.HomeActivity

@Component(modules = [HomeModule::class])
interface HomeComponent {
    fun inject(activity: HomeActivity)
}