package com.kuxln.bankingapp.presentation.core.di

import com.kuxln.bankingapp.data.repository.base.CreditRepository
import com.kuxln.bankingapp.data.repository.base.PurchaseRepository
import com.kuxln.bankingapp.data.repository.base.RefillRepository
import com.kuxln.bankingapp.data.repository.implementation.CreditRepositoryImpl
import com.kuxln.bankingapp.data.repository.implementation.PurchaseRepositoryImpl
import com.kuxln.bankingapp.data.repository.implementation.RefillRepositoryImpl
import com.kuxln.bankingapp.data.room.BankDatabase
import com.kuxln.bankingapp.data.room.dao.CreditDAO
import com.kuxln.bankingapp.data.room.dao.PurchaseDAO
import com.kuxln.bankingapp.data.room.dao.RefillDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CreditModule {

    @Singleton
    @Provides
    fun provideCreditDao(database: BankDatabase): CreditDAO {
        return database.creditDAO()
    }

    @Singleton
    @Provides
    fun provideCreditRepository(creditDAO: CreditDAO): CreditRepository {
        return CreditRepositoryImpl(creditDAO)
    }
}