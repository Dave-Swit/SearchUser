package com.delivery.searchuser.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delivery.searchuser.database.dao.UserDao
import com.delivery.searchuser.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)

abstract class AppDatabase: RoomDatabase() {
    abstract fun UserDao() : UserDao


}