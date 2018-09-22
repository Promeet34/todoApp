package com.promeet.todoapp

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class FirstViewModel : AndroidViewModel{
    constructor(application: Application) : super(application)

    // Inject Repository
    val firstRepository = FirstRepository()
    private val compositeDisposable = CompositeDisposable() // 여러개의 RxJava observer Clear 해주기 위함
    val items: ObservableList<NetworkApi.TodoModel> = ObservableArrayList()     // TODO LiveData

    fun loadFirstDataItems(){
        compositeDisposable += firstRepository.getFirstData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    with(items){
                        clear()
                        addAll(it)
                    }
                },{})


//        compositeDisposable += firstRepository.getFirstData()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(object : DisposableSingleObserver<MutableList<NetworkApi.TodoModel>>(){
//                    override fun onSuccess(t: MutableList<NetworkApi.TodoModel>) {
//                        with(items){
//                            clear()
//                            addAll(t)
//                            empty.set(isEmpty())
//                        }
//                    }
//
//                    override fun onError(e: Throwable) {
//                    }
//                })
//

    }

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }
}