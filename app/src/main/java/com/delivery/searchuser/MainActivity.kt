package com.delivery.searchuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.delivery.searchuser.viewmodel.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.debounce
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val viewModel : UserViewModel by inject ()
    val job = SupervisorJob()
    val activityScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.userList.asFlow()
            .debounce(10)
            .asLiveData()
            .observe(this){

            }

    }
}