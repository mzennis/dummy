package id.mzennis.toktik.login

import androidx.lifecycle.ViewModel
import dagger.Lazy
import id.mzennis.toktik.common.Session
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val session: Lazy<Session>
) : ViewModel() {

    val isLoggedIn: Boolean
        get() {
            return session.get().isLoggedIn
        }

    fun setLogin(state: Boolean) {
        session.get().setLogin(state)
    }
}