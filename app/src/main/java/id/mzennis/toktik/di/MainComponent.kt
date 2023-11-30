package id.mzennis.toktik.di

import dagger.Subcomponent
import id.mzennis.toktik.ui.ChildFragment
import id.mzennis.toktik.ui.ParentFragment

@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(parentFragment: ParentFragment)
    fun inject(childFragment: ChildFragment)
}