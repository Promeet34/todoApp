package com.promeet.todoapp

import io.reactivex.Single

class SecondRepositoryImpl(private val api: NetworkApi) : SecondRepository {

    override fun getItems(): Single<MutableList<NetworkApi.TodoModel>> =
            api.todoApi()
}