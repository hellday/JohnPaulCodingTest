package com.johnpaul.codingtest.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ItemDecoration(private val space: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        // Position of the Item
        val position = parent.getChildAdapterPosition(view)
        // Span Index
        val lp = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
        val spanIndex = lp.spanIndex

        // Add top margin for two first item only
        when(position) {
            0, 1 -> { outRect.top = space }
        }

        // For the Left column
        if (spanIndex == 0){
            outRect.bottom = space
            outRect.left = space
            outRect.right = space/2
        } else {
            outRect.bottom = space
            outRect.left = space/2 + 1
            outRect.right = space
        }
    }
}