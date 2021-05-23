package com.peacecodes.contactlistroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.peacecodes.contactlistroom.db.UserRepository
import com.peacecodes.contactlistroom.models.User
import com.peacecodes.contactlistroom.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Login"

        userRepository = UserRepository(this)

        binding.loginBt.setOnClickListener {
            if (binding.emailEt.text.isNullOrEmpty() || binding.passwordEt.text.isNullOrEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                verifyUserDetails()
            }
        }
        binding.signupTv.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }
    }

    private fun verifyUserDetails() {
        val email = binding.emailEt.text.toString()
        val password = binding.passwordEt.text.toString()

        val user: User = userRepository.findUser(email, password)
        if (user != null) {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("name", user.name)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Incorrect details or Unregistered user", Toast.LENGTH_SHORT).show()
        }
    }
}