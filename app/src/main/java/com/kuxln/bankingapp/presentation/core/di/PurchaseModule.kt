package com.kuxln.bankingapp.presentation.core.di

import com.kuxln.bankingapp.data.repository.base.PurchaseRepository
import com.kuxln.bankingapp.data.repository.base.RefillRepository
import com.kuxln.bankingapp.data.repository.implementation.PurchaseRepositoryImpl
import com.kuxln.bankingapp.data.repository.implementation.RefillRepositoryImpl
import com.kuxln.bankingapp.data.room.BankDatabase
import com.kuxln.bankingapp.data.room.dao.PurchaseDAO
import com.kuxln.bankingapp.data.room.dao.RefillDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PurchaseModule {

    @Singleton
    @Provides
    fun providePurchaseDao(database: BankDatabase): PurchaseDAO {
        return database.purchaseDao()
    }

    @Singleton
    @Provides
    fun providePurchaseRepository(purchaseDAO: PurchaseDAO): PurchaseRepository {
        return PurchaseRepositoryImpl(purchaseDAO)
    }
}