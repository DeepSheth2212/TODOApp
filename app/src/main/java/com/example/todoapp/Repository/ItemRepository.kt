package com.example.todoapp.Repository

import androidx.lifecycle.LiveData
import com.example.todoapp.Room.Item
import com.example.todoapp.Room.ItemDao

class ItemRepository(private val itemDao: ItemDao) {
    fun getItems() : LiveData<List<Item>>{
        return itemDao.getitems()
    }

    suspend fun insertItem(item: Item) = itemDao.insertItem(item)
    suspend fun deleteItem(item: Item) = itemDao.deleteItem(item)
    suspend fun updateItem(item : Item) = itemDao.updateItem(item)
}