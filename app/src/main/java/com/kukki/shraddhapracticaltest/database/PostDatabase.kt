package com.kukki.shraddhapracticaltest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kukki.shraddhapracticaltest.dao.PostDao
import com.kukki.shraddhapracticaltest.data.PostEntity

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
public abstract class PostDatabase : RoomDatabase() {

    abstract fun wordDao(): PostDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PostDatabase? = null

        fun getDatabase(context: Context): PostDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}