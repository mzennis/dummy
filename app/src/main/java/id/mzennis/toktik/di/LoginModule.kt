package id.mzennis.toktik.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.mzennis.toktik.di.viewmodel.ViewModelKey
import id.mzennis.toktik.ui.login.LoginViewModel

@Module(includes = [ViewModelFactoryModule::class])
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}