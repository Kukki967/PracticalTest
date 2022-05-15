package com.kukki.shraddhapracticaltest.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/kukki/shraddhapracticaltest/repo/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/kukki/shraddhapracticaltest/repo/PostRepository;", "(Lcom/kukki/shraddhapracticaltest/repo/PostRepository;)V", "allPosts", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/kukki/shraddhapracticaltest/data/PostVo;", "getAllPosts", "()Landroidx/lifecycle/MutableLiveData;", "getAllPostList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insert", "Lkotlinx/coroutines/Job;", "post", "Lcom/kukki/shraddhapracticaltest/data/PostEntity;", "app_release"})
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    private final com.kukki.shraddhapracticaltest.repo.PostRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.kukki.shraddhapracticaltest.data.PostVo>> allPosts = null;
    
    public PostViewModel(@org.jetbrains.annotations.NotNull()
    com.kukki.shraddhapracticaltest.repo.PostRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.kukki.shraddhapracticaltest.data.PostVo>> getAllPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.kukki.shraddhapracticaltest.data.PostVo> getAllPostList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.kukki.shraddhapracticaltest.data.PostEntity post) {
        return null;
    }
}