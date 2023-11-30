package id.mzennis.toktik.ui

import androidx.lifecycle.ViewModel
import id.mzennis.toktik.data.MyRepository
import id.mzennis.toktik.data.UserSession
import javax.inject.Inject

class ChildViewModel @Inject constructor(
    private val userSession: UserSession,
    private val myRepository: MyRepository
): ViewModel() {

    val isLoggedIn: Boolean
        get() = userSession.isLoggedIn

    fun getMyData(position: Int) = myRepository.getList(position)
}