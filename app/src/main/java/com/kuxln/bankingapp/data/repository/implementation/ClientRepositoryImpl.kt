package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.room.dao.ClientDAO
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import com.kuxln.bankingapp.data.room.exception.ClientAlreadyExistsException
import com.kuxln.bankingapp.data.room.exception.ClientNotFoundException
import com.kuxln.bankingapp.data.room.exception.PhoneNumberNotValidException
import com.kuxln.bankingapp.data.util.getHash
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientRepositoryImpl @Inject constructor(
    private val dao: ClientDAO
) : ClientRepository {

    override suspend fun signUp(client: ClientEntity) {
        val clientFromDB = dao.findClientByLogin(client.login)
        if (clientFromDB != null) throw ClientAlreadyExistsException()
        dao.createClient(
            client.copy(
                password = client.password.getHash()
            )
        )
    }

    override suspend fun signIn(login: String, password: String): Int {
        val clientFromDB = dao.findClientByLoginAndPassword(login, password.getHash())
            ?: throw ClientNotFoundException()
        return clientFromDB.clientId
    }

    override suspend fun changePasswordOnForgot(login: String, newPassword: String) {
        val clientFromDB = dao.findClientByLogin(login) ?: throw ClientNotFoundException()
        dao.updateClient(
            clientFromDB.copy(
                password = newPassword.getHash()
            )
        )
    }

    override suspend fun changeLogin(clientId: Int, newLogin: String) {
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    login = newLogin
                )
            )
        }
    }

    override suspend fun changePassword(clientId: Int, newPassword: String) {
        val clientFromDB = dao.findClientById(clientId)
        if (clientFromDB != null) {
            dao.updateClient(
                clientFromDB.copy(
                    password = newPassword.getHash()
                )
            )
        } else {
            throw ClientNotFoundException()
        }
    }

    override suspend fun changePhoneNumber(clientId: Int, newPhoneNumber: String) {
        if (newPhoneNumber.length < 13) throw PhoneNumberNotValidException()
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    phoneNumber = newPhoneNumber
                )
            )
        }
    }

    override suspend fun changeFirstName(clientId: Int, newFirstName: String) {
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    firstName = newFirstName
                )
            )
        }
    }

    override suspend fun changeLastName(clientId: Int, newLastName: String) {
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    lastName = newLastName
                )
            )
        }
    }

    override suspend fun changePostIndex(clientId: Int, newPostIndex: Int) {
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    postIndex = newPostIndex
                )
            )
        }
    }

    override suspend fun changeAddress(clientId: Int, newAddress: String) {
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    address = newAddress
                )
            )
        }
    }

    override suspend fun changeCreditLimit(clientId: Int, newCreditLimit: Int) {
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    creditLimit = newCreditLimit
                )
            )
        }
    }

    override suspend fun closeClientById(clientId: Int, closeDateMillis: Long) {
        updateIfClientExists(clientId) { clientFromDB ->
            dao.updateClient(
                clientFromDB.copy(
                    endDateMillis = closeDateMillis
                )
            )
        }
    }

    private suspend inline fun updateIfClientExists(
        clientId: Int,
        updateFun: (clientFromDB: ClientEntity) -> Unit
    ) {
        val clientFromDB = dao.findClientById(clientId) ?: throw ClientNotFoundException()
        updateFun(clientFromDB)
    }
}