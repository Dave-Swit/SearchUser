package com.delivery.searchuser.reftrofit

import com.delivery.searchuser.database.entities.UserEntity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

object CustomGsonBuilder {
    fun getCustomConverter(): Converter.Factory {
        return GsonConverterFactory.create(getGsonBuilder())
    }

    fun getGsonBuilder(): Gson {
        val builder = GsonBuilder()
        builder.registerTypeAdapter(UserEntity::class.java, JsonDeserializer<UserEntity> { json, _, _ ->
            var user = UserEntity()

            if (json.isJsonObject) {
                var jsonObject = json.asJsonObject
                user = UserEntity(jsonObject.opt("id", ""), jsonObject.opt("login", ""), jsonObject.opt("avatar_url", ""), isLike = false)

            }

            user
        })

        builder.registerTypeAdapter(object : TypeToken<ArrayList<UserEntity>>() {}.type, JsonDeserializer { json, _, _ ->

            var userList = ArrayList<UserEntity>()
            if (json.isJsonObject) {
                var jsonObject = json.asJsonObject
                if(jsonObject.has("items")) {
                    var userJsonArray = jsonObject.getAsJsonArray("items")
                    userJsonArray.forEach {
                        userList.add(getGsonBuilder().fromJson(it.toString(), UserEntity::class.java))
                    }
                }
            }
            userList
        })

        return builder.create()
    }

    private fun JsonObject.opt(key: String, fallBack: String = ""): String {
        return if (!this.has(key) || this[key].isJsonNull) {
            fallBack
        } else {
            this[key].asString
        }
    }
}
