package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.room.dao.ClientDAO
import com.kuxln.bankingapp.data.util.getHash
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientRepositoryImpl @Inject constructor(
    private val dao: ClientDAO
) : ClientRepository {

    override suspend fun signUp(client: com.kuxln.bankingapp.data.room.entity.ClientEntity) {
        val clientFromDB = dao.findClientByLogin(client.login)
        if (clientFromDB != null) {
            throw com.kuxln.bankingapp.data.room.exception.ClientAlreadyExistsException()
        } else {
            dao.createClient(client.copy(
                password = client.password.getHash()
            ))
        }
    }

    override suspend fun login(login: String, password: String): Int {
        val clientFromDB = dao.findClientByLoginAndPassword(login, password.getHash())
        if (clientFromDB != null) {
            return clientFromDB.clientId
        } else {
            throw com.kuxln.bankingapp.data.room.exception.ClientNotFoundException()
        }
    }

    override suspend fun changePassword(login: String, newPassword: String) {
        val clientFromDB = dao.findClientByLogin(login)
        if (clientFromDB != null) {
            dao.updateClient(
                clientFromDB.copy(
                    password = newPassword.getHash()
                )
            )
        } else {
            throw com.kuxln.bankingapp.data.room.exception.ClientNotFoundException()
        }
    }
}
