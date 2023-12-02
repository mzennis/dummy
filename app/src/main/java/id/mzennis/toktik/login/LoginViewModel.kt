package id.mzennis.toktik.login

import androidx.lifecycle.ViewModel
import dagger.Lazy
import id.mzennis.toktik.common.UserSession
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userSession: Lazy<UserSession>
) : ViewModel() {

    val isLoggedIn: Boolean
        get() {
            return userSession.get().isLoggedIn
        }

    fun setLogin(state: Boolean) {
        userSession.get().setLogin(state)
    }
}