package com.kuxln.bankingapp.presentation.core.di

import android.content.Context
import com.kuxln.bankingapp.data.datastore.DataStore
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
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore {
        return DataStore(context)
    }
}