package id.mzennis.toktik.common

import id.mzennis.toktik.common.util.logRefClass
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSession @Inject constructor() {

    val isLoggedIn: Boolean
        get() {
            logRefClass(this)
            return mIsLoggedIn
        }

    private var mIsLoggedIn = false

    fun setLogin(state: Boolean) {
        mIsLoggedIn = state
    }
}