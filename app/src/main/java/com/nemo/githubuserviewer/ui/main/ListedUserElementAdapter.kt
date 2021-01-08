package com.nemo.githubuserviewer.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nemo.githubuserviewer.databinding.ListedUserElementBinding
import com.nemo.githubuserviewer.model.data.ListedUser

class ListedUserElementAdapter(val itemClick: ItemClick<ListedUser>) : PagedListAdapter<ListedUser, RecyclerView.ViewHolder>(DiffCallback) {

    class ViewHolder(var binding: ListedUserElementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListedUser, itemClick: ItemClick<ListedUser>) {
            binding.item = item
            binding.itemClick = itemClick
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listedUserElementBinding = ListedUserElementBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(listedUserElementBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                getItem(position)?.let {
                    holder.bind(it, itemClick)
                }
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ListedUser>() {
        override fun areItemsTheSame(oldItem: ListedUser, newItem: ListedUser): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ListedUser, newItem: ListedUser): Boolean {
            return (oldItem.id == newItem.id)
        }

    }
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, url: String) {
    imageView.let {
        it.context.apply {
            Glide.with(this)
                    .load(url)
                    .into(it)
        }
    }
}
