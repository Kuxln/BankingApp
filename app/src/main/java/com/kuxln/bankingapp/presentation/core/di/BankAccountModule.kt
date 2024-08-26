package com.kuxln.bankingapp.presentation.core.di

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.repository.implementation.BankAccountRepositoryImpl
import com.kuxln.bankingapp.data.repository.implementation.ClientRepositoryImpl
import com.kuxln.bankingapp.data.room.BankDatabase
import com.kuxln.bankingapp.data.room.dao.BankAccountDAO
import com.kuxln.bankingapp.data.room.dao.ClientDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class BankAccountModule {

    @Singleton
    @Provides
    fun provideBankAccountDao(database: BankDatabase): BankAccountDAO {
        return database.bankAccountDao()
    }

    @Singleton
    @Provides
    fun provideBankAccountRepository(bankAccountDAO: BankAccountDAO): BankAccountRepository {
        return BankAccountRepositoryImpl(bankAccountDAO)
    }
}