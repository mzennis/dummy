package id.mzennis.toktik.login

import androidx.lifecycle.ViewModel
import id.mzennis.toktik.common.UserSession
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userSession: UserSession
) : ViewModel() {

    val isLoggedIn: Boolean
        get() = userSession.isLoggedIn

    fun setLogin(state: Boolean) {
        userSession.setLogin(state)
    }
}