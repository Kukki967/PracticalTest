package com.kukki.shraddhapracticaltest

import Post
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.kukki.shraddhapracticaltest.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var requestQueue: RequestQueue

    private var adapter: PostListRecyclerViewAdapter = PostListRecyclerViewAdapter()
    private val postList = ArrayList<Post>()

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

        getData()

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
        val filteredList: ArrayList<Post> = ArrayList()

        for (item in postList) {
            if (item.name.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                filteredList.add(item)
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "Oops !!! \n No data found", Toast.LENGTH_SHORT).show()
        } else {
            adapter.submitList(filteredList)
        }
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

                    val post = Post(id, postId, name, email, body)

                    postList.add(post)
                }

                initList()

            } catch (w: Exception) {
                w.printStackTrace()
            }
        }) { error ->
            Toast.makeText(this, "Oops !!! \n error occured", Toast.LENGTH_SHORT).show()
        }

        requestQueue.add(jsonArrayRequest)

    }

    fun initList() {
        adapter.submitList(postList)

        postList.sortBy {
            it.name
        }

        binding.postsListView.adapter = adapter
    }

}