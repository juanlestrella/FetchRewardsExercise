package com.example.fetchrewards

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewards.network.FetchData
import com.example.fetchrewards.ItemAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FetchData>?) {
    val adapter = recyclerView.adapter as ItemAdapter
    adapter.submitList(data)
}