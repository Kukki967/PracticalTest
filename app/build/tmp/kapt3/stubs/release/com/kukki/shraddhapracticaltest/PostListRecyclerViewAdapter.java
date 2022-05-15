package com.kukki.shraddhapracticaltest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/kukki/shraddhapracticaltest/PostListRecyclerViewAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/kukki/shraddhapracticaltest/data/PostVo;", "Lcom/kukki/shraddhapracticaltest/PostListRecyclerViewAdapter$ViewHolder;", "()V", "binderHelper", "Lcom/chauthai/swipereveallayout/ViewBinderHelper;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemCallback", "ViewHolder", "app_release"})
public final class PostListRecyclerViewAdapter extends androidx.recyclerview.widget.ListAdapter<com.kukki.shraddhapracticaltest.data.PostVo, com.kukki.shraddhapracticaltest.PostListRecyclerViewAdapter.ViewHolder> {
    private final com.chauthai.swipereveallayout.ViewBinderHelper binderHelper = null;
    
    public PostListRecyclerViewAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kukki.shraddhapracticaltest.PostListRecyclerViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.kukki.shraddhapracticaltest.PostListRecyclerViewAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/kukki/shraddhapracticaltest/PostListRecyclerViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/kukki/shraddhapracticaltest/databinding/ItemListBinding;", "(Lcom/kukki/shraddhapracticaltest/databinding/ItemListBinding;)V", "bind", "", "vo", "Lcom/kukki/shraddhapracticaltest/data/PostVo;", "app_release"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.kukki.shraddhapracticaltest.databinding.ItemListBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.kukki.shraddhapracticaltest.databinding.ItemListBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.kukki.shraddhapracticaltest.data.PostVo vo) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/kukki/shraddhapracticaltest/PostListRecyclerViewAdapter$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/kukki/shraddhapracticaltest/data/PostVo;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class ItemCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.kukki.shraddhapracticaltest.data.PostVo> {
        
        public ItemCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.kukki.shraddhapracticaltest.data.PostVo oldItem, @org.jetbrains.annotations.NotNull()
        com.kukki.shraddhapracticaltest.data.PostVo newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.kukki.shraddhapracticaltest.data.PostVo oldItem, @org.jetbrains.annotations.NotNull()
        com.kukki.shraddhapracticaltest.data.PostVo newItem) {
            return false;
        }
    }
}