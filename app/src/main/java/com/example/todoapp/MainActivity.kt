package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Adapter.ItemAdapter
import com.example.todoapp.Adapter.ItemClicked
import com.example.todoapp.Repository.ItemRepository
import com.example.todoapp.Room.Item
import com.example.todoapp.Room.ItemDatabase
import com.example.todoapp.ViewModel.ItemViewModel
import com.example.todoapp.ViewModel.ItemViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), ItemClicked {


    lateinit var itemViewModel : ItemViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action_btn = findViewById<FloatingActionButton>(R.id.action_btn)
        action_btn.setOnClickListener {
            startActivity(Intent(this , AddActivity::class.java))
        }

        val itemDao = ItemDatabase.getDatabase(this).ItemDao()
        val itemRepository = ItemRepository(itemDao)
        val itemViewModelFactory = ItemViewModelFactory(itemRepository)
        itemViewModel = ViewModelProvider(this,itemViewModelFactory)[ItemViewModel::class.java]
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        val adapter = ItemAdapter(ArrayList(),this)
        recyclerView.adapter = adapter
        itemViewModel.getItems().observe(this) {
            adapter.setData(it)
        }
    }

    override fun onItemClicked(item: Item) {
        val intent = Intent(this , ViewActivity::class.java)
        intent.putExtra("Title",item.title)
        intent.putExtra("Desc",item.description)
        intent.putExtra("time",item.time.toString())
        startActivity(intent)
    }

    override fun onRemoveClicked(item: Item) {
        itemViewModel.deleteItem(item)
    }


}