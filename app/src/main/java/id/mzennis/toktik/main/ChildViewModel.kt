package id.mzennis.toktik.main

import androidx.lifecycle.ViewModel
import id.mzennis.toktik.common.Session
import id.mzennis.toktik.common.util.logRefClass
import id.mzennis.toktik.main.data.MyRepository
import javax.inject.Inject

class ChildViewModel @Inject constructor(
    private val session: Session,
    private val myRepository: MyRepository
): ViewModel() {

    val isLoggedIn: Boolean
        get() = session.isLoggedIn

    fun getMyData(position: Int): List<String> {
        logRefClass(this)
        return myRepository.getList(position)
    }
}