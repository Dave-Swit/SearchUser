package com.delivery.searchuser

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.delivery.searchuser.di.databaseModule
import com.delivery.searchuser.di.viewmodeModule
import com.delivery.searchuser.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@Application)

            modules(listOf(
                databaseModule,
                viewmodeModule
            ))
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

        MultiDex.install(this@Application)
    }

}