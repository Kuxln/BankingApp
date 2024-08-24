package com.kuxln.bankingapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kuxln.bankingapp.data.repository.implementation.PurchaseTypeRepositoryImpl
import com.kuxln.bankingapp.data.room.dao.BankAccountDAO
import com.kuxln.bankingapp.data.room.dao.ClientDAO
import com.kuxln.bankingapp.data.room.dao.CreditDAO
import com.kuxln.bankingapp.data.room.dao.CreditTypeDAO
import com.kuxln.bankingapp.data.room.dao.DepositDAO
import com.kuxln.bankingapp.data.room.dao.DepositTypeDAO
import com.kuxln.bankingapp.data.room.dao.PurchaseDAO
import com.kuxln.bankingapp.data.room.dao.PurchaseTypeDAO
import com.kuxln.bankingapp.data.room.dao.RefillDAO
import com.kuxln.bankingapp.data.room.dao.RefillTypeDAO
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import com.kuxln.bankingapp.data.room.entity.CreditEntity
import com.kuxln.bankingapp.data.room.entity.CreditTypeEntity
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import com.kuxln.bankingapp.data.room.entity.DepositTypeEntity
import com.kuxln.bankingapp.data.room.entity.PurchaseEntity
import com.kuxln.bankingapp.data.room.entity.PurchaseTypeEntity
import com.kuxln.bankingapp.data.room.entity.RefillEntity
import com.kuxln.bankingapp.data.room.entity.RefillTypeEntity

@Database(
    entities = [
        BankAccountEntity::class,
        ClientEntity::class,
        CreditEntity::class,
        CreditTypeEntity::class,
        DepositEntity::class,
        DepositTypeEntity::class,
        PurchaseEntity::class,
        PurchaseTypeEntity::class,
        RefillEntity::class,
        RefillTypeEntity::class,
    ],
    version = 1
)
abstract class BankDatabase : RoomDatabase() {
    abstract fun bankAccountDao(): BankAccountDAO
    abstract fun clientDao(): ClientDAO
    abstract fun creditDAO(): CreditDAO
    abstract fun creditTypeDao(): CreditTypeDAO
    abstract fun depositDao(): DepositDAO
    abstract fun depositTypeDao(): DepositTypeDAO
    abstract fun purchaseDao(): PurchaseDAO
    abstract fun purchaseTypeDao(): PurchaseTypeDAO
    abstract fun refillDao(): RefillDAO
    abstract fun refillTypeDAO(): RefillTypeDAO
}