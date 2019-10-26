package com.johnpaul.codingtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.johnpaul.codingtest.adapter.ItemAdapter
import com.johnpaul.codingtest.adapter.VerticalSpaceItemDecoration
import com.johnpaul.codingtest.models.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(recycler_view) {
            itemAdapter = ItemAdapter(items)
            addItemDecoration(VerticalSpaceItemDecoration(context.resources.getDimensionPixelSize(R.dimen.list_vertical_margin)))
            adapter = itemAdapter
        }

        swipe_refresh.setOnRefreshListener {
            refreshItems()
        }

        refreshItems()
    }


    private fun refreshItems() {
        swipe_refresh.isRefreshing = true
        Item.list {
            items.clear()
            items.addAll(it)
            itemAdapter.notifyDataSetChanged()
            swipe_refresh.isRefreshing = false
        }
    }

}
