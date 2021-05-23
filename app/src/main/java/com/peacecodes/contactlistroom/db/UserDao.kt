package com.peacecodes.contactlistroom.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.peacecodes.contactlistroom.models.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun findUser(email: String, password: String): User
}