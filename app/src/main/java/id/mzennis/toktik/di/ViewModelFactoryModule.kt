package id.mzennis.toktik.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import id.mzennis.toktik.di.viewmodel.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}