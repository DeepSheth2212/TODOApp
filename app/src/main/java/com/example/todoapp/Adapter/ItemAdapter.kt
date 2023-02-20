package com.example.todoapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoapp.R
import com.example.todoapp.Room.Item

class ItemAdapter ( var itemList : List<Item> , private val listener : ItemClicked): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : ViewHolder(itemView){
        val item_textView = itemView.findViewById<TextView>(R.id.item_textView)
        val remove_btn = itemView.findViewById<ImageButton>(R.id.remove_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        val viewHolder =  ItemViewHolder(view)

        view.setOnClickListener {
            listener.onItemClicked(itemList[viewHolder.adapterPosition])
        }

        viewHolder.remove_btn.setOnClickListener {
            listener.onRemoveClicked(itemList[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.item_textView.text = itemList[position].title
    }

    fun setData(itemList: List<Item>){
        this.itemList = itemList
        notifyDataSetChanged()
    }
}

interface ItemClicked{
    fun onItemClicked(item : Item)
    fun onRemoveClicked(item:Item)
}

