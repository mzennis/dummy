package id.mzennis.toktik.main.data

interface MyRepository {

    fun getList(position: Int): List<String>
}