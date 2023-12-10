package id.mzennis.toktik.home.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val name: String,
    @SerializedName("languages")
    val languages: List<Language>,
) {
    data class Language(
        @SerializedName("name")
        val name: String
    )

    data class Response(
        @SerializedName("data")
        val data: Data
    )

    data class Data(
        @SerializedName("countries")
        val countries: List<Country>
    )
}