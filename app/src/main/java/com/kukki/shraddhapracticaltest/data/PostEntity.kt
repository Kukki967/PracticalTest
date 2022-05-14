package com.kukki.shraddhapracticaltest.data

import androidx.room.Entity

@Entity
data class PostEntity(
    var id: Int,
    var postId: Int,
    var name: String,
    var email: String,
    var body: String
)