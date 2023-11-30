package id.mzennis.toktik.main.data

import javax.inject.Inject

class MyRepositoryImpl @Inject constructor() : MyRepository {

    override fun getList(position: Int): List<String> {
        val dummies =  buildList {
            add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
            add("when an unknown printer took a galley of type and scrambled it to make a type specimen book")
            add("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
            add("It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged")
            add("It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages")
            add("and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        }
        val whatNumber = position % 2
        return dummies.filterIndexed { index, _ -> index % 2 == whatNumber }
    }
}