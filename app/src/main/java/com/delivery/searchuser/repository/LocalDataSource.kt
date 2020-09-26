package com.delivery.searchuser.repository

import com.delivery.searchuser.database.AppDatabase
import com.delivery.searchuser.database.entities.UserEntity

class LocalDataSource(private val api: AppDatabase) {

    fun inserUser(user:UserEntity) {
        api.UserDao().insertUser(user)
    }

    fun updateLike(id : String, flag : Boolean) {
        api.UserDao().updateLike(id, flag)
    }

}