package com.promeet.todoapp

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class SecondHolderViewModel : ViewModel() {

    private val imageUrl = MutableLiveData<String>()
    private val content = MutableLiveData<String>()

    fun bind(item: NetworkApi.TodoModel) {

        imageUrl.value = item.url
        content.value = item.content
    }

    fun getImageUrl(): MutableLiveData<String> = imageUrl

    fun getContent(): MutableLiveData<String> = content
}

@BindingAdapter("imageUrl")
fun setImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
            .load(url)
            .into(imageView)
}