package com.gangadhari.rsandroidtakehomechallenge.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Driver
import com.gangadhari.rsandroidtakehomechallenge.domain.repositories.DataRepository
import com.gangadhari.rsandroidtakehomechallenge.domain.usecases.GetDriversUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getDriversUseCase: GetDriversUseCase,
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _drivers = MutableStateFlow<List<Driver>>(emptyList())
    val drivers: StateFlow<List<Driver>> = _drivers.asStateFlow()

    init {
        viewModelScope.launch {
            dataRepository.fetchAndSaveData()
            getDriversUseCase().collect {
                _drivers.value = it
            }
        }
    }

    fun sortDrivers(){
        viewModelScope.launch {
            getDriversUseCase().collect {
                _drivers.value = it.sortedBy { it.name }
            }
        }
    }
}
