package com.promeet.todoapp

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.promeet.todoapp.databinding.SecondItemBinding

class SecondAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<NetworkApi.TodoModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: SecondItemBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.second_item, parent, false)
        return SecondViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {
        (holder as SecondViewHolder).bind(items[p1])
    }

    fun addItems(items: MutableList<NetworkApi.TodoModel>) {
        this.items.addAll(items)
    }
}

class SecondViewHolder(private val binding: SecondItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    private val viewModel = SecondHolderViewModel()

    fun bind(item: NetworkApi.TodoModel) {

        viewModel.bind(item)
        binding.viewModel = this.viewModel
    }
}
