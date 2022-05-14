package com.kukki.shraddhapracticaltest.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kukki.shraddhapracticaltest.dao.PostDao
import com.kukki.shraddhapracticaltest.data.PostEntity
import kotlinx.coroutines.launch

class PostRepository(private val postDao: PostDao) {

    val allPosts: List<PostEntity> = postDao.getPosts()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(Post: PostEntity) {
        postDao.insert(Post)
    }
}


class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val allPosts: List<PostEntity> = repository.allPosts

    fun insert(post: PostEntity) = viewModelScope.launch {
        repository.insert(post)
    }
}