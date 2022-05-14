package com.kukki.shraddhapracticaltest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class PostEntity(
    var id: Int,
    @PrimaryKey var postId: Int,
    @ColumnInfo(name = "name") var name: String,
    var email: String,
    var body: String
)
