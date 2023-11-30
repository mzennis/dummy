package id.mzennis.toktik.data

import android.util.Log

class UserSession {

    val isLoggedIn: Boolean
        get() {
            Log.d("MzennisApp", "Ref of ${this::class.java.canonicalName} class: $this")
            return mIsLoggedIn
        }

    private var mIsLoggedIn = false

    fun setLogin(state: Boolean) {
        mIsLoggedIn = state
    }
}