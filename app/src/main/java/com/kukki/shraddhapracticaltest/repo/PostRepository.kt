package com.kukki.shraddhapracticaltest.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kukki.shraddhapracticaltest.dao.PostDao
import com.kukki.shraddhapracticaltest.data.PostEntity
import com.kukki.shraddhapracticaltest.data.PostVo
import kotlinx.coroutines.launch

class PostRepository(private val postDao: PostDao) {


    fun getAllPosts(): List<PostEntity> {
        return postDao.getPosts()
    }

    @WorkerThread
    suspend fun insert(Post: PostEntity) {
        postDao.insert(Post)
    }
}


class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val allPosts = MutableLiveData<List<PostVo>>()

    fun getAllPostList(): ArrayList<PostVo> {
        val postEntityList = repository.getAllPosts()
        val postList = ArrayList<PostVo>()

        for (post in postEntityList) {
            val postVo = PostVo()
            postVo.postId = post.postId
            postVo.id = post.id
            postVo.name = post.name
            postVo.email = post.email
            postVo.body = post.body

            postList.add(postVo)
        }

        allPosts.postValue(postList)

        return postList
    }

    fun insert(post: PostEntity) = viewModelScope.launch {
        repository.insert(post)
    }
}


class WordViewModelFactory(private val repository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}