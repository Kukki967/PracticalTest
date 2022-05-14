package com.kukki.shraddhapracticaltest

import android.app.Application
import com.kukki.shraddhapracticaltest.database.PostDatabase
import com.kukki.shraddhapracticaltest.repo.PostRepository

class PostApplication : Application() {

    val database by lazy { PostDatabase.getDatabase(this) }
    val repository by lazy { PostRepository(database.wordDao()) }
}