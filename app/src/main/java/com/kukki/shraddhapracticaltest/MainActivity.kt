package com.kukki.shraddhapracticaltest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.kukki.shraddhapracticaltest.data.PostEntity
import com.kukki.shraddhapracticaltest.data.PostVo
import com.kukki.shraddhapracticaltest.databinding.ActivityMainBinding
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
    private var postList = ArrayList<PostVo>()

    private var sortedBy: String = "ASCENDING"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val view = binding.root

        setContentView(view)

        initUiComponent()
    }

    private fun initUiComponent() {
        //get response from json
        GlobalScope.launch(Dispatchers.IO) {
            postList = postViewModel.getAllPostList()

            if(postList.isNullOrEmpty()) {
                getData()
            } else {
                initList()
            }
        }

        requestQueue = Volley.newRequestQueue(this)


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

                    val postEntity = PostEntity(id, postId, name, email, body)

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

    private fun initList() {
        adapter.submitList(postList)

        postList.sortBy {
            it.name
        }

        binding.postsListView.adapter = adapter

    }

}