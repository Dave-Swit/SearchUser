package com.delivery.searchuser.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delivery.searchuser.database.entities.UserEntity

interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user")
    fun selectUser() : List<UserEntity>

    @Query("UPDATE user set isLike = :isLike Where id = :id ")
    fun updateLike(id:String, isLike : Boolean)

    @Query("DELETE FROM user")
    fun deleteAll()
}