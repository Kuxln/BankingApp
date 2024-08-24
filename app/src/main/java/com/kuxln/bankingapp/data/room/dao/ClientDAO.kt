package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kuxln.bankingapp.data.room.entity.ClientEntity

@Dao
interface ClientDAO {

    @Insert
    suspend fun createClient(client: com.kuxln.bankingapp.data.room.entity.ClientEntity)

    @Query("SELECT * FROM client WHERE login = :login AND password = :password")
    suspend fun findClientByLoginAndPassword(login: String, password: String): com.kuxln.bankingapp.data.room.entity.ClientEntity?

    @Query("SELECT * FROM client WHERE login = :login")
    suspend fun findClientByLogin(login: String): com.kuxln.bankingapp.data.room.entity.ClientEntity?

    @Update
    suspend fun updateClient(client: com.kuxln.bankingapp.data.room.entity.ClientEntity)
}