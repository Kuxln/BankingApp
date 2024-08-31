package com.kuxln.bankingapp.presentation.services.aboutclient

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import com.kuxln.bankingapp.domain.usecases.client.GetClientUseCase
import com.kuxln.bankingapp.domain.usecases.client.UpdateClientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutClientViewModel @Inject constructor(
    private val updateClientUseCase: UpdateClientUseCase,
    getClientUseCase: GetClientUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val clientId: Int = savedStateHandle["client_id"] ?: throw IllegalStateException()
    val uiState = getClientUseCase(clientId)

    fun onUpdate(
        login: String,
        phoneNumber: String,
        lastName: String,
        firstName: String,
        address: String,
        creditLimit: Int,
        postIndex: Int
    ) {
        viewModelScope.launch {
            updateClientUseCase(
                ClientEntity(
                    clientId = clientId,
                    login = login,
                    phoneNumber = phoneNumber,
                    lastName = lastName,
                    firstName = firstName,
                    address = address,
                    creditLimit = creditLimit,
                    postIndex = postIndex,
                    startDateMillis = -1,
                    password = ""
                )
            )
        }

    }
}