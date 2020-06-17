package com.example.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<String> = mutableListOf("")

    fun addItem(message: String) {
        items.add(message)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.produto, parent, false)

        return itemViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = items[position]
        if (holder is itemViewHolder) {
            holder.itemTextView.text = currentItem
        }
    }

    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTextView: TextView = itemView.findViewById(R.id.textview_name_item)
    }
}