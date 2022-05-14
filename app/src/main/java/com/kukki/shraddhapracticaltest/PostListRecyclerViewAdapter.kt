package com.kukki.shraddhapracticaltest

import com.kukki.shraddhapracticaltest.data.PostVo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kukki.shraddhapracticaltest.databinding.ItemListBinding

class PostListRecyclerViewAdapter : androidx.recyclerview.widget.ListAdapter<PostVo, PostListRecyclerViewAdapter.ViewHolder>(ItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)
            .let { card ->
                with(holder) {
                    itemView.tag = card
                    bind(card)
                }
            }
    }

    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(card: PostVo) {
            binding.name.text = card.name
            binding.email.text = card.email
            binding.body.text = card.body
        }
    }


    private class ItemCallback : DiffUtil.ItemCallback<PostVo>() {

        override fun areItemsTheSame(oldItem: PostVo, newItem: PostVo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PostVo, newItem: PostVo): Boolean {
            return oldItem.id == newItem.id
        }
    }

}