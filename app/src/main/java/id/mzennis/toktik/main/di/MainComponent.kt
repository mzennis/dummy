package id.mzennis.toktik.main.di

import dagger.Component
import id.mzennis.toktik.common.di.ApplicationComponent
import id.mzennis.toktik.main.ChildFragment

@MainScope
@Component(
    modules = [MainModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainComponent {
    fun inject(childFragment: ChildFragment)
}