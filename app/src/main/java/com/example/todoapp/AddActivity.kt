package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.Repository.ItemRepository
import com.example.todoapp.Room.Item
import com.example.todoapp.Room.ItemDatabase
import com.example.todoapp.ViewModel.ItemViewModel
import com.example.todoapp.ViewModel.ItemViewModelFactory

class AddActivity : AppCompatActivity() {

    lateinit var itemViewModel: ItemViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val title = findViewById<EditText>(R.id.add_title)
        val desc = findViewById<EditText>(R.id.add_description)
        val btn = findViewById<Button>(R.id.add_btn)

        val itemDao = ItemDatabase.getDatabase(this).ItemDao()
        val itemRepository = ItemRepository(itemDao)
        val itemViewModelFactory = ItemViewModelFactory(itemRepository)
        itemViewModel = ViewModelProvider(this,itemViewModelFactory)[ItemViewModel::class.java]


        btn.setOnClickListener {
            itemViewModel.insertItem(Item(title = title.text.toString() , description = desc.text.toString(),id=0))
            finish()
        }
    }
}