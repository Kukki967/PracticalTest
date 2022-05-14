package com.kukki.shraddhapracticaltest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kukki.shraddhapracticaltest.data.PostVo
import com.kukki.shraddhapracticaltest.databinding.ItemListBinding
import com.kukki.shraddhapracticaltest.swipe.OnSwipeDeleteListener
import com.kukki.shraddhapracticaltest.swipe.ViewBinderHelper


class PostListRecyclerViewAdapter() :
    ListAdapter<PostVo, PostListRecyclerViewAdapter.ViewHolder>(ItemCallback()) {


    lateinit var onSwipeDeleteListener: OnSwipeDeleteListener
    private val binderHelper = ViewBinderHelper()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_list, parent, false
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
            with(binding) {
                executePendingBindings()
            }
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