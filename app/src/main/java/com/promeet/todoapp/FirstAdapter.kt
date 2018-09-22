package com.promeet.todoapp

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_first.view.*

class FirstAdapter(
        val items: MutableList<NetworkApi.TodoModel>
) : RecyclerView.Adapter<FirstHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FirstHolder {
        return FirstHolder(p0)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: FirstHolder, p1: Int) {
        items[p1].let {
            with(p0){
                contentView.text = it.content
                urlView.text = it.url
            }
        }
    }

    fun setDatas(itemList: MutableList<NetworkApi.TodoModel>) {
        items.clear()
        items.addAll(itemList)
        notifyDataSetChanged()
    }
}

// TODO 생명주기.
class FirstHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
                .inflate(R.layout.item_first, parent, false)){

    val contentView = itemView.first_content
    val urlView = itemView.first_url
}