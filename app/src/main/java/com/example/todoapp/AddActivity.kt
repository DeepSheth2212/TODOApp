package com.example.todoapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.Repository.ItemRepository
import com.example.todoapp.Room.Item
import com.example.todoapp.Room.ItemDatabase
import com.example.todoapp.ViewModel.ItemViewModel
import com.example.todoapp.ViewModel.ItemViewModelFactory
import java.time.LocalDateTime
import java.util.Calendar

class AddActivity : AppCompatActivity() {

    lateinit var itemViewModel: ItemViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val title = findViewById<EditText>(R.id.add_title)
        val desc = findViewById<EditText>(R.id.add_description)
        val add_btn = findViewById<Button>(R.id.add_btn)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)

        val itemDao = ItemDatabase.getDatabase(this).ItemDao()
        val itemRepository = ItemRepository(itemDao)
        val itemViewModelFactory = ItemViewModelFactory(itemRepository)
        itemViewModel = ViewModelProvider(this,itemViewModelFactory)[ItemViewModel::class.java]

        val alarmManager = getSystemService(AlarmManager::class.java)



        add_btn.setOnClickListener {

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.set(Calendar.MINUTE , timePicker.minute)
            calendar.set(Calendar.HOUR_OF_DAY,timePicker.hour)
            val intent = Intent(this , AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pendingIntent)
            itemViewModel.insertItem(Item(title = title.text.toString() , description = desc.text.toString(),id=0, time = timePicker.hour.toString()+" : "+timePicker.minute.toString()))
            finish()
        }
    }
}