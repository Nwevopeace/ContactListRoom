package com.peacecodes.contactlistroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.peacecodes.contactlistroom.db.UserRepository
import com.peacecodes.contactlistroom .models.User
import com.peacecodes.contactlistroom.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Sign up"

        userRepository = UserRepository(this)

        binding.signupBt.setOnClickListener {
            if (binding.nameEt.text.isNullOrEmpty() || binding.emailEt.text.isNullOrEmpty() || binding.passwordEt.text.isNullOrEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                saveUserDetails()
            }
        }
        binding.loginTv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun saveUserDetails() {
        val user = User(
            name = binding.nameEt.text.toString(),
            email = binding.emailEt.text.toString(),
            password = binding.passwordEt.text.toString()
        )
        userRepository.insertUser(user)
        Toast.makeText(this, "User saved successfully", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}