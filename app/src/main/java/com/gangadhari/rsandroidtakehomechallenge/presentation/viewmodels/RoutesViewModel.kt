package com.gangadhari.rsandroidtakehomechallenge.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Route
import com.gangadhari.rsandroidtakehomechallenge.domain.usecases.GetRoutesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutesViewModel @Inject constructor(private val getRoutesUseCase: GetRoutesUseCase) : ViewModel() {

    private val _routes = MutableStateFlow<List<Route>>(emptyList())
    val routes: StateFlow<List<Route>> = _routes.asStateFlow()

    fun loadRoutes(driverId: Int) {
        viewModelScope.launch {
            getRoutesUseCase(driverId).collect {
                _routes.value = it
            }
        }
    }
}
