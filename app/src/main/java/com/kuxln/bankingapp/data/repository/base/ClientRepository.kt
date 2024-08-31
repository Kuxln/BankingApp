package com.kuxln.bankingapp.data.repository.base

import com.kuxln.bankingapp.data.room.entity.ClientEntity
import kotlinx.coroutines.flow.Flow

interface ClientRepository {

    suspend fun signUp(client: ClientEntity)

    suspend fun signIn(login: String, password: String): Int

    suspend fun changePasswordOnForgot(login: String, newPassword: String)

    fun getClientById(clientId: Int): Flow<ClientEntity?>

    suspend fun updateClient(clientEntity: ClientEntity)

    suspend fun changeLogin(clientId: Int, newLogin: String)

    suspend fun changePassword(clientId: Int, newPassword: String)

    suspend fun changePhoneNumber(clientId: Int, newPhoneNumber: String)

    suspend fun changeFirstName(clientId: Int, newFirstName: String)

    suspend fun changeLastName(clientId: Int, newLastName: String)

    suspend fun changePostIndex(clientId: Int, newPostIndex: Int)

    suspend fun changeAddress(clientId: Int, newAddress: String)

    suspend fun changeCreditLimit(clientId: Int, newCreditLimit: Int)

    suspend fun closeClientById(clientId: Int, closeDateMillis: Long)
}
