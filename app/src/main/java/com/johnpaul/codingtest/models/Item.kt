package com.johnpaul.codingtest.models

data class Item(var index: Int) {

    companion object {
        fun list(block: (List<Item>) -> Unit) {
            val items = (1..10).map { Item(it) }
            block(items)
        }
    }
}