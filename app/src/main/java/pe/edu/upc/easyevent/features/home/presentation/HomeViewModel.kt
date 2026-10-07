package pe.edu.upc.easyevent.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easyevent.features.home.application.GetEventsUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getEvents: GetEventsUseCase) : ViewModel() {

    private val _state = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    fun  loadEvents() {
        viewModelScope.launch(Dispatchers.IO) {

            val result = getEvents()
            _state.value = result.fold(
                onSuccess = { events -> HomeUiState.Success(events) },
                onFailure = { error -> HomeUiState.Error(error.message ?: "Unknown error") }
            )

        }
    }

    init {
        loadEvents()
    }
}