package com.delivery.searchuser.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel(){
    val disposables : CompositeDisposable = CompositeDisposable()

    operator fun CompositeDisposable.plus(disposable: Disposable){
        disposables.add(disposables)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}