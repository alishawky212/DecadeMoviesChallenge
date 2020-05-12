package com.example.decademovieschallenge.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.decademovieschallenge.model.ListItem

abstract class BaseListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: ListItem)
}