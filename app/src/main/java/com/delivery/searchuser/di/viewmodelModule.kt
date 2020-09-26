package com.delivery.searchuser.di

import com.delivery.searchuser.repository.LocalDataSource
import com.delivery.searchuser.repository.RemoteDataSource
import com.delivery.searchuser.repository.Repository
import com.delivery.searchuser.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val viewmodeModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource() }
    single { Repository(get(), get()) }
    single { UserViewModel(get(), androidContext()) }
}