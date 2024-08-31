package com.kuxln.bankingapp.presentation.core.di

import com.kuxln.bankingapp.data.room.BankDatabase
import com.kuxln.bankingapp.data.room.dao.CreditTypeDAO
import com.kuxln.bankingapp.data.room.dao.DepositTypeDAO
import com.kuxln.bankingapp.data.room.dao.PurchaseTypeDAO
import com.kuxln.bankingapp.data.room.dao.RefillTypeDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EntityTypesModule {

    @Singleton
    @Provides
    fun provideRefillTypeDao(database: BankDatabase): RefillTypeDAO {
        return database.refillTypeDAO()
    }

    @Singleton
    @Provides
    fun providePurchaseTypeDao(database: BankDatabase): PurchaseTypeDAO {
        return database.purchaseTypeDao()
    }

    @Singleton
    @Provides
    fun provideCreditTypeDao(database: BankDatabase): CreditTypeDAO {
        return database.creditTypeDao()
    }

    @Singleton
    @Provides
    fun provideDepositTypeDao(database: BankDatabase): DepositTypeDAO {
        return database.depositTypeDao()
    }
}