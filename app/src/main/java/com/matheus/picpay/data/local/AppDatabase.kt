package com.matheus.picpay.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matheus.picpay.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}