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


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var requestQueue: RequestQueue

    private var adapter: PostListRecyclerViewAdapter = PostListRecyclerViewAdapter()
    private val postList = ArrayList<Post>()

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
                postList.sortBy {
                    it.email
                }
            }
        }

    }

    private fun filter(text: String) {
        val filteredlist: ArrayList<Post> = ArrayList()

        for (item in postList) {
            if (item.email.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }

            if (item.body.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }

            if (item.name.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }

            if (item.id == text.toInt()) {
                filteredlist.add(item)
            }

            if (item.postId == text.toInt()) {
                filteredlist.add(item)
            }
        }

        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "Oops !!! \n No data found", Toast.LENGTH_SHORT).show()
        } else {
            adapter.submitList(filteredlist)
        }
    }

    private fun getData() {
        val url = "https://jsonplaceholder.typicode.com/comments"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, { response ->
            println("xcxcxcxc success ${response.length()}")

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

                adapter.submitList(postList)
                binding.postsListView.adapter = adapter

            } catch (w: Exception) {
                w.printStackTrace()
            }
        }) { error ->
            println("xcxcxcxc error ${error.message}")
            Toast.makeText(this, "Oops !!! \n error occured", Toast.LENGTH_SHORT).show()

        }
        requestQueue.add(jsonArrayRequest)

    }

}