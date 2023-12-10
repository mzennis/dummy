package id.mzennis.toktik.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.mzennis.toktik.home.model.Country
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val countries: StateFlow<List<Country>>
        get() = repository.getCountries()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(1000),
                initialValue = emptyList()
            )
}