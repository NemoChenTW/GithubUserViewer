package com.nemo.githubuserviewer.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nemo.githubuserviewer.databinding.FollowerElementBinding
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser

class FollowerElementAdapter : ListAdapter<ListedUser, RecyclerView.ViewHolder>(DiffCallback) {

    class ViewHolder(var binding: FollowerElementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listedUser: ListedUser) {
            binding.item = listedUser
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val followerElementBinding = FollowerElementBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(followerElementBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                getItem(position)?.let {
                    holder.bind(it)
                }
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ListedUser>() {
        override fun areItemsTheSame(oldItem: ListedUser, newItem: ListedUser): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ListedUser, newItem: ListedUser): Boolean {
            return (oldItem.login == newItem.login && oldItem.avatar_url == newItem.avatar_url)
        }

    }


}