package com.delivery.searchuser.di

import androidx.room.Room
import com.delivery.searchuser.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, "test").build() }
}