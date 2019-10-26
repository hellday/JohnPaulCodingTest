package com.johnpaul.codingtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.johnpaul.codingtest.R
import com.johnpaul.codingtest.models.Item
import com.johnpaul.codingtest.utils.ItemDiffUtilCallback

class ItemAdapter() : RecyclerView.Adapter<ItemViewHolder>() {
    private var items : List<Item> = listOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(items[position])


    // Method for the DiffUtilCallback
    fun updateList(newItems: List<Item>) {
        val diffCallback = ItemDiffUtilCallback(this.items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)

        this.items = newItems
    }

}

