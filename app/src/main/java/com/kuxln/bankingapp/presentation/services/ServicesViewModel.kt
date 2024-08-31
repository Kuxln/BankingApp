package com.kuxln.bankingapp.presentation.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.datastore.DataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServicesViewModel @Inject constructor(
    private val dataStore: DataStore,
): ViewModel() {

    private var clientId: Int? = null
    private val _clientIdFlow = MutableSharedFlow<Int?>(1)
    val clientIdFlow = _clientIdFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            dataStore.clientIdFlow.collect { savedClientId ->
                savedClientId?.let {
                    clientId = savedClientId
                    _clientIdFlow.emit(clientId)
                }
            }
        }
    }
}