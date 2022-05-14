package com.kukki.shraddhapracticaltest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.kukki.shraddhapracticaltest.data.PostEntity
import com.kukki.shraddhapracticaltest.data.PostVo
import com.kukki.shraddhapracticaltest.database.PostDatabase
import com.kukki.shraddhapracticaltest.databinding.ActivityMainBinding
import com.kukki.shraddhapracticaltest.repo.PostRepository
import com.kukki.shraddhapracticaltest.repo.PostViewModel
import com.kukki.shraddhapracticaltest.repo.WordViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var requestQueue: RequestQueue

//    private val postViewModel: PostViewModel by viewModels()

    private val postViewModel: PostViewModel by viewModels {
        WordViewModelFactory((application as PostApplication).repository)
    }


    private var adapter: PostListRecyclerViewAdapter = PostListRecyclerViewAdapter()
    private val postList = ArrayList<PostVo>()

    private var sortedBy: String = "ASCENDING"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        initUiComponent()
    }

    private fun initUiComponent() {
        //get response from json
        requestQueue = Volley.newRequestQueue(this)

//        getData()

        fetchFromRoom()

        binding.apply {

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filter(newText!!)
                    return false
                }
            })

            sortButton.setOnClickListener {

                if (sortedBy == "ASCENDING") {
                    sortedBy = "DESCENDING"
                    postList.sortByDescending {
                        it.name
                    }
                } else {
                    sortedBy = "ASCENDING"
                    postList.sortBy {
                        it.name
                    }
                }

            }
        }

    }

    private fun filter(text: String) {
        val filteredList: ArrayList<PostVo> = ArrayList()

        for (item in postList) {
            if (item.name.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                filteredList.add(item)
            }
        }

        adapter.submitList(filteredList)

    }

    private fun getData() {
        val url = "https://jsonplaceholder.typicode.com/comments"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, { response ->
            try {

                for (i in 0 until response.length()) {
                    val jsonObject = response.getJSONObject(i)

                    val id = jsonObject.getInt("id")
                    val postId = jsonObject.getInt("postId")
                    val name = jsonObject.getString("name")
                    val email = jsonObject.getString("email")
                    val body = jsonObject.getString("body")

                    val postVo = PostVo()
                    postVo.id = id
                    postVo.postId = postId
                    postVo.name = name
                    postVo.email = email
                    postVo.body = body

                    val postEntity = PostEntity(id,postId,name, email, body)

                    postList.add(postVo)


                    GlobalScope.launch(Dispatchers.IO) {
                        postViewModel.insert(postEntity)
                    }
                }

                initList()

            } catch (w: Exception) {
                println("exception occured")
                w.printStackTrace()
            }
        }) { error ->
            Toast.makeText(this, "Oops !!! \n error occured", Toast.LENGTH_SHORT).show()
        }

        requestQueue.add(jsonArrayRequest)

    }

    private fun fetchFromRoom() {
        val thread = Thread {
            val postEntityList: List<PostEntity> = postViewModel.allPosts

            postList.clear()

            for (post in postEntityList) {
                val postVo = PostVo()
                postVo.postId = post.postId
                postVo.id = post.id
                postVo.name = post.name
                postVo.email = post.email
                postVo.body = post.body

                postList.add(postVo)
            }
            initList()
            // refreshing recycler view
        }
        thread.start()
    }

    private fun initList() {
        adapter.submitList(postList)

        postList.sortBy {
            it.name
        }

        binding.postsListView.adapter = adapter
    }

}