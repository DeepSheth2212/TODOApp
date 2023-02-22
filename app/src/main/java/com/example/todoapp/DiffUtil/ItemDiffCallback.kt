package com.example.todoapp.DiffUtil

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallback(private val old: List<com.example.todoapp.Room.Item>, private val new: List<com.example.todoapp.Room.Item>): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].id == new[newItemPosition].id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition]== new[newItemPosition]
    }
}