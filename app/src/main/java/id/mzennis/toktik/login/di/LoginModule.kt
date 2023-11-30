package id.mzennis.toktik.login.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.mzennis.toktik.common.di.viewmodel.ViewModelFactoryModule
import id.mzennis.toktik.common.di.viewmodel.ViewModelKey
import id.mzennis.toktik.login.LoginViewModel

@Module(includes = [ViewModelFactoryModule::class])
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}