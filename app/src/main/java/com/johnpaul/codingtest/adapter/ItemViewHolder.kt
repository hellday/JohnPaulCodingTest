package com.johnpaul.codingtest.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.johnpaul.codingtest.models.Item
import com.johnpaul.codingtest.utils.SizeUtil
import kotlinx.android.synthetic.main.row_item.view.*

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    fun bind(item: Item) {
        val position = item.index

        with(item) {
            itemView.title.text = index.toString()

            // Height of each item
            if (position % 2 > 0) {
                itemView.title.layoutParams.height = SizeUtil.tallHeight
            }else {
                itemView.title.layoutParams.height = SizeUtil.shortHeight
            }
            // Width of each item
            itemView.layoutParams.width = SizeUtil.width
        }
    }
}