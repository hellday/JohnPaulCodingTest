package com.johnpaul.codingtest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.johnpaul.codingtest.models.Item

class MainViewModel : ViewModel() {
    val _items = MutableLiveData<List<Item>>()

    val items : LiveData<List<Item>>
        get() = _items

    init {
        // Init Item
        Item.list {
            _items.value = it
        }
    }
}