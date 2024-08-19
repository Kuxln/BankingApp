package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.dao.ClientDAO
import com.kuxln.bankingapp.data.repository.base.ClientRepository
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(
    private val dao: ClientDAO
): ClientRepository {

}
