package id.mzennis.toktik.main

import androidx.lifecycle.ViewModel
import id.mzennis.toktik.common.UserSession
import id.mzennis.toktik.common.util.logRefClass
import id.mzennis.toktik.main.data.MyRepository
import javax.inject.Inject

class ChildViewModel @Inject constructor(
    private val userSession: UserSession,
    private val myRepository: MyRepository
): ViewModel() {

    val isLoggedIn: Boolean
        get() = userSession.isLoggedIn

    fun getMyData(position: Int): List<String> {
        logRefClass(this)
        return myRepository.getList(position)
    }
}