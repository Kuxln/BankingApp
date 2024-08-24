package com.kuxln.bankingapp.presentation.core.di

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.repository.implementation.ClientRepositoryImpl
import com.kuxln.bankingapp.data.room.BankDatabase
import com.kuxln.bankingapp.data.room.dao.ClientDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ClientModule {

    @Singleton
    @Provides
    fun provideClientDao(database: BankDatabase): ClientDAO {
        return database.clientDao()
    }

    @Singleton
    @Provides
    fun provideClientRepository(clientDao: ClientDAO): ClientRepository {
        return ClientRepositoryImpl(clientDao)
    }
}