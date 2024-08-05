package com.example.blogapp
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: PostViewModel by viewModels { PostViewModelFactory(PostRepository(RetrofitInstance.api)) }
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter()
        recyclerView.adapter = postAdapter

        viewModel.posts.observe(this, Observer { posts ->
            postAdapter.submitList(posts)
        })

        // Handle creating a new post
        // Use viewModel.createPost(...) to create a new post
    }
}

