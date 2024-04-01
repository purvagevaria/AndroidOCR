package com.project.androidocr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CategorySelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_selection)


        var model = ItemsViewModel("Milk", "10", "Food")
        var array = ArrayList<ItemsViewModel>()
        array.add(model)
        val rvContacts = findViewById<View>(R.id.recyclerview) as RecyclerView
        // Initialize contacts
        // Create adapter passing in the sample user data
        val adapter = CustomAdapter(array)
        // Attach the adapter to the recyclerview to populate items
        rvContacts.adapter = adapter
        // Set layout manager to position the items
        rvContacts.layoutManager = LinearLayoutManager(this)
    }
}