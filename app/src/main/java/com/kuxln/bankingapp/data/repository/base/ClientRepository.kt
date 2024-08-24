package com.kuxln.bankingapp.data.repository.base

interface ClientRepository {

    suspend fun signUp(client: com.kuxln.bankingapp.data.room.entity.ClientEntity)

    suspend fun login(login: String, password: String): Int

    suspend fun changePassword(login: String, newPassword: String)
}
