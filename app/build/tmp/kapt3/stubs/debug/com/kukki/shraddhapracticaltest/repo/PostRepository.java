package com.kukki.shraddhapracticaltest.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/kukki/shraddhapracticaltest/repo/PostRepository;", "", "postDao", "Lcom/kukki/shraddhapracticaltest/dao/PostDao;", "(Lcom/kukki/shraddhapracticaltest/dao/PostDao;)V", "allPosts", "", "Lcom/kukki/shraddhapracticaltest/data/PostEntity;", "getAllPosts", "()Ljava/util/List;", "insert", "", "Post", "(Lcom/kukki/shraddhapracticaltest/data/PostEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PostRepository {
    private final com.kukki.shraddhapracticaltest.dao.PostDao postDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.kukki.shraddhapracticaltest.data.PostEntity> allPosts = null;
    
    public PostRepository(@org.jetbrains.annotations.NotNull()
    com.kukki.shraddhapracticaltest.dao.PostDao postDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.kukki.shraddhapracticaltest.data.PostEntity> getAllPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.kukki.shraddhapracticaltest.data.PostEntity Post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}