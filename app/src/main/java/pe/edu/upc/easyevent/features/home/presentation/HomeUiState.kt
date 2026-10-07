package pe.edu.upc.easyevent.features.home.presentation

import pe.edu.upc.easyevent.features.home.domain.Event

sealed class HomeUiState {
    class Success(val events: List<Event>) : HomeUiState()
    class Error(val message: String) : HomeUiState()
    object Loading : HomeUiState()
}
