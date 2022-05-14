package com.kukki.shraddhapracticaltest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/kukki/shraddhapracticaltest/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/kukki/shraddhapracticaltest/PostListRecyclerViewAdapter;", "binding", "Lcom/kukki/shraddhapracticaltest/databinding/ActivityMainBinding;", "postList", "Ljava/util/ArrayList;", "Lcom/kukki/shraddhapracticaltest/data/PostVo;", "postViewModel", "Lcom/kukki/shraddhapracticaltest/repo/PostViewModel;", "getPostViewModel", "()Lcom/kukki/shraddhapracticaltest/repo/PostViewModel;", "postViewModel$delegate", "Lkotlin/Lazy;", "requestQueue", "Lcom/android/volley/RequestQueue;", "sortedBy", "", "fetchFromRoom", "", "filter", "text", "getData", "initList", "initUiComponent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.kukki.shraddhapracticaltest.databinding.ActivityMainBinding binding;
    private com.android.volley.RequestQueue requestQueue;
    private final kotlin.Lazy postViewModel$delegate = null;
    private com.kukki.shraddhapracticaltest.PostListRecyclerViewAdapter adapter;
    private final java.util.ArrayList<com.kukki.shraddhapracticaltest.data.PostVo> postList = null;
    private java.lang.String sortedBy = "ASCENDING";
    
    public MainActivity() {
        super();
    }
    
    private final com.kukki.shraddhapracticaltest.repo.PostViewModel getPostViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initUiComponent() {
    }
    
    private final void filter(java.lang.String text) {
    }
    
    private final void getData() {
    }
    
    private final void fetchFromRoom() {
    }
    
    private final void initList() {
    }
}