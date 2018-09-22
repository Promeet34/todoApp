package com.promeet.todoapp

import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class SecondViewModel(private val repository: SecondRepository) : ViewModel() {

    private val composite = CompositeDisposable()

    val adapter = SecondAdapter()

    override fun onCleared() {
        composite.clear()
        super.onCleared()
    }

    init {
        composite.add(getItems())
    }

    private fun getItems() =
            repository.getItems()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess {
                        adapter.addItems(it)
                        adapter.notifyDataSetChanged()
                    }
                    .subscribe()
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}