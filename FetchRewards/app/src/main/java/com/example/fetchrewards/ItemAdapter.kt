package com.example.fetchrewards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewards.databinding.ListItemBinding
import com.example.fetchrewards.network.FetchData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


class ItemAdapter : ListAdapter<FetchData, ItemAdapter.ItemViewHolder>(DiffCallback) {

    class ItemViewHolder(private var binding: ListItemBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(FetchData: FetchData) {
            binding.data = FetchData
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FetchData>(){

        override fun areItemsTheSame(oldItem: FetchData, newItem: FetchData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FetchData, newItem: FetchData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}