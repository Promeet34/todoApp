package com.promeet.todoapp

import io.reactivex.Single

class FirstRepository {

    fun getFirstData() : Single<MutableList<NetworkApi.TodoModel>> {
        return NetworkApi.create().todoApi()
    }
}