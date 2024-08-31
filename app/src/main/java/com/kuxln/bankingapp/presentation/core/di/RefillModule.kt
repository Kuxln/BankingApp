package com.kuxln.bankingapp.presentation.core.di

import com.kuxln.bankingapp.data.repository.base.RefillRepository
import com.kuxln.bankingapp.data.repository.implementation.RefillRepositoryImpl
import com.kuxln.bankingapp.data.room.BankDatabase
import com.kuxln.bankingapp.data.room.dao.RefillDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RefillModule {

    @Singleton
    @Provides
    fun provideRefillDao(database: BankDatabase): RefillDAO {
        return database.refillDao()
    }

    @Singleton
    @Provides
    fun provideRefillRepository(refillDAO: RefillDAO): RefillRepository {
        return RefillRepositoryImpl(refillDAO)
    }
}