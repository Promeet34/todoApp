package com.promeet.todoapp

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class SecondViewModelFactory(private val repository: SecondRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SecondViewModel(repository) as T
    }
}