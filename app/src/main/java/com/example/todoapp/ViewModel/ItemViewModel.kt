package com.example.todoapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.Repository.ItemRepository
import com.example.todoapp.Room.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(private val itemRepository: ItemRepository) : ViewModel() {
    //val itemList : MutableLiveData<List<Item>> = MutableLiveData()

    fun getItems() : LiveData<List<Item>> = itemRepository.getItems()

    fun insertItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            itemRepository.insertItem(item)

        }
    }

    fun deleteItem(item: Item){
        viewModelScope.launch (Dispatchers.IO){
            itemRepository.deleteItem(item)
        }
    }
}