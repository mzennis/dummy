package id.mzennis.toktik.common.network

import id.mzennis.toktik.home.model.Country
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson

val ktorClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        gson()
    }
}

object NetworkService {

    private const val URL = "https://countries.trevorblades.com/"

    suspend fun getCountries(): List<Country> {
        val response = ktorClient.post(URL) {
            contentType(ContentType.Application.Json)
            setBody("{\"query\":\"query{countries{name languages{name}}}\",\"variables\":{}}")
        }.body<Country.Response>()
        return response.data.countries
    }
}