package com.promeet.todoapp

import io.reactivex.Single

interface SecondRepository {

    fun getItems(): Single<MutableList<NetworkApi.TodoModel>>
}