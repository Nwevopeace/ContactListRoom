package com.peacecodes.contactlistroom.db

import android.content.Context
import com.peacecodes.contactlistroom.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository(context: Context) {
    private val db = UserDatabase.invoke(context)

    fun insertUser(user: User) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                db.userDao().insertUser(user)
            }
        }
    }

    fun findUser(email: String, password: String): User = db.userDao().findUser(email, password)
}