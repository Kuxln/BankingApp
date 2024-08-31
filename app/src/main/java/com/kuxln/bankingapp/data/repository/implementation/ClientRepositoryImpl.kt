package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.datastore.DataStore
import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.room.dao.ClientDAO
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import com.kuxln.bankingapp.data.room.exception.ClientAlreadyExistsException
import com.kuxln.bankingapp.data.room.exception.ClientNotExistsException
import com.kuxln.bankingapp.data.util.hashing
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientRepositoryImpl @Inject constructor(
    private val dao: ClientDAO,
    private val dataStore: DataStore,
) : ClientRepository {

    override suspend fun signUp(client: ClientEntity) {
        val clientFromDB = dao.findClientByLogin(client.login)
        if (clientFromDB != null) throw ClientAlreadyExistsException()
        dao.createClient(
            client.copy(
                password = client.password.hashing()
            )
        )
        dao.findClientByLogin(client.login)?.clientId?.let {
            dataStore.saveClientId(it)
        }
    }

    override suspend fun signIn(login: String, password: String): Int {
        val clientFromDB = dao.findClientByLoginAndPassword(login, password.hashing())
            ?: throw ClientNotExistsException()
            dataStore.saveClientId( clientFromDB.clientId)
        return clientFromDB.clientId
    }

    override suspend fun changePasswordOnForgot(login: String, newPassword: String) {
//        val clientFromDB = dao.findClientByLogin(login) ?: throw ClientNotExistsException()
//        dao.updateClient(
//            clientFromDB.copy(
//                password = newPassword.hashing()
//            )
//        )
    }

    override fun getClientById(clientId: Int): Flow<ClientEntity?> {
        return flow { emit(dao.findClientById(clientId)) }
    }

    override suspend fun updateClient(clientEntity: ClientEntity) {
        dao.updateClient(
            clientEntity.clientId,
            clientEntity.login,
            clientEntity.phoneNumber,
            clientEntity.lastName,
            clientEntity.firstName,
            clientEntity.postIndex ?: -1,
            clientEntity.address,
            clientEntity.creditLimit,
        )
    }

    override suspend fun changeLogin(clientId: Int, newLogin: String) {
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
////                clientFromDB.copy(
////                    login = newLogin
////                )
////            )
//        }
    }

    override suspend fun changePassword(clientId: Int, newPassword: String) {
        val clientFromDB = dao.findClientById(clientId)
//        if (clientFromDB != null) {
//            dao.updateClient(
//                clientFromDB.copy(
//                    password = newPassword.hashing()
//                )
//            )
//        } else {
//            throw ClientNotExistsException()
//        }
    }

    override suspend fun changePhoneNumber(clientId: Int, newPhoneNumber: String) {
//        if (newPhoneNumber.length < 13) throw PhoneNumberNotValidException()
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
//                clientFromDB.copy(
//                    phoneNumber = newPhoneNumber
//                )
//            )
//        }
    }
//
    override suspend fun changeFirstName(clientId: Int, newFirstName: String) {
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
//                clientFromDB.copy(
//                    firstName = newFirstName
//                )
//            )
//        }
    }
//
    override suspend fun changeLastName(clientId: Int, newLastName: String) {
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
//                clientFromDB.copy(
//                    lastName = newLastName
//                )
//            )
//        }
    }
//
    override suspend fun changePostIndex(clientId: Int, newPostIndex: Int) {
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
//                clientFromDB.copy(
//                    postIndex = newPostIndex
//                )
//            )
//        }
    }
//
    override suspend fun changeAddress(clientId: Int, newAddress: String) {
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
//                clientFromDB.copy(
//                    address = newAddress
//                )
//            )
//        }
    }
//
    override suspend fun changeCreditLimit(clientId: Int, newCreditLimit: Int) {
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
//                clientFromDB.copy(
//                    creditLimit = newCreditLimit
//                )
//            )
//        }
    }
//
    override suspend fun closeClientById(clientId: Int, closeDateMillis: Long) {
//        updateIfClientExists(clientId) { clientFromDB ->
//            dao.updateClient(
//                clientFromDB.copy(
//                    endDateMillis = closeDateMillis
//                )
//            )
//        }
    }

    private suspend inline fun updateIfClientExists(
        clientId: Int,
        updateFun: (clientFromDB: ClientEntity) -> Unit
    ) {
        val clientFromDB = dao.findClientById(clientId) ?: throw ClientNotExistsException()
        updateFun(clientFromDB)
    }
}