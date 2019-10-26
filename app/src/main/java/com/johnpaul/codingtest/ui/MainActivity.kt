package com.johnpaul.codingtest.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.johnpaul.codingtest.R
import com.johnpaul.codingtest.adapter.ItemAdapter
import com.johnpaul.codingtest.adapter.ItemDecoration
import com.johnpaul.codingtest.models.Item
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Staggered Grid Layout Manager :  2 columns
        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // Viewmodel
        viewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        // Observer
        viewModel.items.observe(this,
            Observer {
                updateListData(it)
            })

        // Recycler View
        with(recycler_view) {
            itemAdapter = ItemAdapter()
            addItemDecoration(ItemDecoration(context.resources.getDimensionPixelSize(R.dimen.list_vertical_margin)))
            adapter = itemAdapter
            layoutManager = manager
            Log.d("Test Width", (recycler_view.width).toString() )
        }



        swipe_refresh.setOnRefreshListener {
            refreshItems()
        }
    }


    private fun refreshItems() {
        swipe_refresh.isRefreshing = true
        updateListData(viewModel.items.value!!)
        swipe_refresh.isRefreshing = false
    }

    // DiffUtils Call (normally on the main thread) inside a Coroutine
    private fun updateListData(it : List<Item>){
        CoroutineScope(Dispatchers.Default).launch {
            itemAdapter.updateList(it)
        }
    }

}
