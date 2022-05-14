package com.kukki.shraddhapracticaltest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kukki.shraddhapracticaltest.data.PostEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PostDao {

    @Query("SELECT * FROM post_table ORDER BY name ASC")
    fun getPosts(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: PostEntity)

    @Query("DELETE FROM post_table")
    suspend fun deleteAll()
}