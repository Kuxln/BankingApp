package com.kuxln.bankingapp.presentation.core.di

import com.kuxln.bankingapp.data.repository.base.DepositRepository
import com.kuxln.bankingapp.data.repository.implementation.DepositRepositoryImpl
import com.kuxln.bankingapp.data.room.BankDatabase
import com.kuxln.bankingapp.data.room.dao.DepositDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DepositModule {

    @Singleton
    @Provides
    fun provideDepositDao(database: BankDatabase): DepositDAO {
        return database.depositDao()
    }

    @Singleton
    @Provides
    fun provideDepositRepository(depositDao: DepositDAO): DepositRepository {
        return DepositRepositoryImpl(depositDao)
    }
}