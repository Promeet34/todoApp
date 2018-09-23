package com.promeet.todoapp

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.arch.lifecycle.ViewModelProviders
import com.promeet.todoapp.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {

    private val api by lazy { NetworkApi.create() }
    private val repository by lazy { SecondRepositoryImpl(api) }

    private lateinit var viewModelFactory: SecondViewModelFactory
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.second_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
        }

        viewModelFactory = SecondViewModelFactory(repository) // TODO Dagger

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(SecondViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this) // Factory가 필요함
    }
}