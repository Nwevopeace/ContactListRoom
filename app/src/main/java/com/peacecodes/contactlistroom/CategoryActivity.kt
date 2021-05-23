package com.peacecodes.contactlistroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.peacecodes.contactlistroom.adapter.CategoryAdapter
import com.peacecodes.contactlistroom.models.Category
import com.peacecodes.contactlistroom.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Category"
        intent?.let {
            Toast.makeText(this, "Welcome ${it.getStringExtra("name")}", Toast.LENGTH_LONG).show()
        }
        setupCategory(binding)
    }

    private fun setupCategory(binding: ActivityCategoryBinding) {
        val categories = listOf(
            Category("FA", "Family"),
            Category("BS", "Business"),
            Category("FS", "Friends"),
            Category("CS", "Colleagues"),
            Category("TS", "Tutors")
        )
        val adapter = CategoryAdapter(categories)
        binding.categoryRv.adapter = adapter
        binding.categoryRv.layoutManager = GridLayoutManager(this, 2)
        binding.categoryRv.setHasFixedSize(true)
    }
}