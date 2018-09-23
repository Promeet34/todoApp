package com.promeet.todoapp


import android.arch.lifecycle.ViewModelProviders
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.promeet.todoapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentFirstBinding
    private lateinit var adapter: FirstAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Context -> NetManager -> GitRepoRepository -> ViewModelFactory
        adapter = FirstAdapter(mutableListOf())

        val viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        viewDataBinding.viewmodel = viewModel

        // RecyclerView Set Adapter
        viewDataBinding.firstRecyclerView.adapter = adapter
        viewDataBinding.executePendingBindings()
        viewModel.loadFirstDataItems()
    }

}

object DataListBinding {
    @BindingAdapter("items")
    @JvmStatic
    fun getItemData(recyclerView: RecyclerView, items: MutableList<NetworkApi.TodoModel>) {
        with(recyclerView.adapter as FirstAdapter) {
            this.setDatas(items)
        }
    }
}


// Adapter
// Util