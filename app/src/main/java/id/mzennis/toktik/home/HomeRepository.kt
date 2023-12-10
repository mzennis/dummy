package id.mzennis.toktik.home

import id.mzennis.toktik.common.network.NetworkService
import id.mzennis.toktik.home.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepository @Inject constructor() {

    fun getCountries(): Flow<List<Country>> = flow {
        emit(NetworkService.getCountries())
    }.flowOn(Dispatchers.IO)
}