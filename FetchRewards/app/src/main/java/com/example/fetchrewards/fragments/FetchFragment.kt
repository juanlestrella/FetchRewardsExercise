package com.example.fetchrewards.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fetchrewards.ItemAdapter
import com.example.fetchrewards.databinding.FragmentFetchBinding
import com.example.fetchrewards.models.FetchViewModel

class FetchFragment : Fragment(){

    private lateinit var viewModel: FetchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFetchBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(FetchViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.itemList.adapter = ItemAdapter()

        viewModel.data.observe(viewLifecycleOwner) {
                dataList -> (binding.itemList.adapter as ItemAdapter).submitList(dataList)
        }
        return binding.root
    }
}