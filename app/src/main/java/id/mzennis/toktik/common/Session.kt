package id.mzennis.toktik.common

import id.mzennis.toktik.common.util.logRefClass

class Session {

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