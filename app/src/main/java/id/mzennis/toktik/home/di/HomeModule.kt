package id.mzennis.toktik.home.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.mzennis.toktik.common.di.viewmodel.ViewModelFactoryModule
import id.mzennis.toktik.common.di.viewmodel.ViewModelKey
import id.mzennis.toktik.home.HomeViewModel

@Module(includes = [ViewModelFactoryModule::class])
abstract class HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindViewModel(viewModel: HomeViewModel): ViewModel
}