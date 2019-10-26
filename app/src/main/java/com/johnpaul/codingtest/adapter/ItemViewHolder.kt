package com.johnpaul.codingtest.adapter

import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.johnpaul.codingtest.models.Item
import kotlinx.android.synthetic.main.row_item.view.*

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Item) {
        with(item) {
            itemView.title.text = index.toString()
        }
    }
}