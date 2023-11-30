package id.mzennis.toktik.main.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.mzennis.toktik.common.di.viewmodel.ViewModelFactoryModule
import id.mzennis.toktik.common.di.viewmodel.ViewModelKey
import id.mzennis.toktik.main.ChildViewModel
import id.mzennis.toktik.main.data.MyRepository
import id.mzennis.toktik.main.data.MyRepositoryImpl

@Module(includes = [ViewModelFactoryModule::class])
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChildViewModel::class)
    abstract fun bindChildViewModel(childViewModel: ChildViewModel): ViewModel

    @MainScope
    @Binds
    abstract fun bindRepository(myRepositoryImpl: MyRepositoryImpl): MyRepository
}