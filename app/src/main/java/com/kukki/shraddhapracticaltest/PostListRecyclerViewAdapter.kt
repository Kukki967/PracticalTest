package com.kukki.shraddhapracticaltest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.kukki.shraddhapracticaltest.data.PostVo
import com.kukki.shraddhapracticaltest.databinding.ItemListBinding

class PostListRecyclerViewAdapter : ListAdapter<PostVo, PostListRecyclerViewAdapter.ViewHolder>(ItemCallback()) {

    private val binderHelper = ViewBinderHelper()
//    lateinit var onSwipeDeleteListener: OnSwipeDeleteListener

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
            .let { vo ->
                with(holder) {
                    itemView.tag = vo
//                    binderHelper.bind(itemView.swipe, position.toString())

                    bind(vo)

                    /* itemView.btnDelete.setOnClickListener {
                        binderHelper.openOnlyOne = false
                        binderHelper.bind(itemView.swipe, position.toString())

                        onSwipeDeleteListener.onDeleteButtonClicked(vo, position)
                        notifyItemRemoved(position)
                    } */

                }
            }
    }


    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(vo: PostVo) {
            with(binding) {
                vm = PostItemViewModel(vo)
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