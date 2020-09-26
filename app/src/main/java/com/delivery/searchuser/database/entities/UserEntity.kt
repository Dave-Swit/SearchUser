package com.delivery.searchuser.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey var id : String = "",
    var name : String = "",
    var profile_name : String = "",
    var isLike : Boolean = false
)