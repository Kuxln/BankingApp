package com.kuxln.bankingapp.presentation.core.di

import android.content.Context
import androidx.room.Room
import com.kuxln.bankingapp.data.room.BankDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideBankDatabase(@ApplicationContext applicationContext: Context): BankDatabase {
        return Room.databaseBuilder(
            applicationContext,
            BankDatabase::class.java,
            "bank-database"
        ).build()
    }
}