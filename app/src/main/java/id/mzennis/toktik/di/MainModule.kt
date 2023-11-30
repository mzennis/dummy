package id.mzennis.toktik.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.mzennis.toktik.data.MyRepository
import id.mzennis.toktik.data.MyRepositoryImpl
import id.mzennis.toktik.di.viewmodel.ViewModelKey
import id.mzennis.toktik.ui.ChildViewModel

@Module(includes = [ViewModelFactoryModule::class])
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChildViewModel::class)
    abstract fun bindChildViewModel(childViewModel: ChildViewModel): ViewModel

    @Binds
    abstract fun bindRepository(myRepositoryImpl: MyRepositoryImpl): MyRepository
}