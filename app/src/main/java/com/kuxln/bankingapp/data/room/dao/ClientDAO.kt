package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kuxln.bankingapp.data.room.entity.ClientEntity

//insert into client values(1, "login", "password", 0,"Kulesh", "Andrii", 0, "address", 0, 0, 0, 0)
@Dao
interface ClientDAO {

    @Insert
    suspend fun createClient(client: ClientEntity)

    @Query("SELECT * FROM client WHERE login = :login AND password = :password")
    suspend fun findClientByLoginAndPassword(login: String, password: String): ClientEntity?

    @Query("SELECT * FROM client WHERE login = :login")
    suspend fun findClientByLogin(login: String): ClientEntity?

    @Query("SELECT * FROM client WHERE clientId = :clientId")
    suspend fun findClientById(clientId: Int): ClientEntity?

    @Update
    suspend fun updateClient(client: ClientEntity)

    @Query("UPDATE client SET end_date = :closeDateMillis WHERE clientId = :clientId")
    suspend fun closeClientById(clientId: Int, closeDateMillis: Long)
}