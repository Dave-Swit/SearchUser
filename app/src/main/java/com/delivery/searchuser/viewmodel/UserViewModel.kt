package com.delivery.searchuser.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delivery.searchuser.database.entities.UserEntity
import com.delivery.searchuser.reftrofit.RetrofitProcess
import com.delivery.searchuser.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(
    private val repo : Repository,
    private val context:Context
) : BaseViewModel() {

    var userList = MutableLiveData<ArrayList<UserEntity>>()

    fun searchUserList(query : String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var result = RetrofitProcess.callApi {
                    RetrofitProcess.retrofit().getUserList(query).execute()
                }

                if(result != null) {
                    result.forEach {
//                        repo.localApi.inserUser(it)
                    }
                }
            }
        }
    }
}