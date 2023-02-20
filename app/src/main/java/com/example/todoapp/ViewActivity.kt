package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val title_txt = intent.getStringExtra("Title")
        val desc_txt = intent.getStringExtra("Desc")

        val title_view = findViewById<TextView>(R.id.view_title)
        val desc_view = findViewById<TextView>(R.id.view_description)
        title_view.text = title_txt
        desc_view.text = desc_txt
    }
}