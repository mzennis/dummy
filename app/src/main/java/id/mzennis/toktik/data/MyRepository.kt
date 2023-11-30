package id.mzennis.toktik.data

interface MyRepository {

    fun getList(position: Int): List<String>
}