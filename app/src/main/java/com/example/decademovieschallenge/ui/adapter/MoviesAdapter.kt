package com.example.decademovieschallenge.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.decademovieschallenge.R
import com.example.decademovieschallenge.inflate
import com.example.decademovieschallenge.model.ItemType
import com.example.decademovieschallenge.model.ListItem
import com.example.decademovieschallenge.model.MovieItem
import com.example.decademovieschallenge.model.YearItem
import kotlinx.android.synthetic.main.category_list_item.view.*
import kotlinx.android.synthetic.main.movie_list_item.view.*
import javax.inject.Inject

private const val TYPE_DATE = 0
private const val TYPE_GENERAL = 1

class MoviesAdapter @Inject constructor() : RecyclerView.Adapter<BaseListViewHolder>() {

    private val moviesList = mutableListOf<ListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder {
        return when (viewType) {
            TYPE_GENERAL -> MovieViewHolder(parent.inflate(R.layout.movie_list_item))
            TYPE_DATE -> YearViewHolder(parent.inflate(R.layout.category_list_item))
            else -> throw Exception("Not Supported View Type")
        }
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: BaseListViewHolder, position: Int) {
        val item = moviesList[position]
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        val item = moviesList[position]
        return when (item.getType()) {
            ItemType.YEAR_TYPE -> TYPE_DATE
            ItemType.MOVIE_TYPE -> TYPE_GENERAL
        }
    }

    fun setData(items: List<ListItem>) {
        val diffResult =
            DiffUtil.calculateDiff(MoviesDiffUtilCallback(this.moviesList, items))
        this.moviesList.clear()
        this.moviesList.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class MovieViewHolder(itemView: View) : BaseListViewHolder(itemView) {
        override fun bind(item: ListItem) {
            item as MovieItem
            with(itemView) {
                tvMovieName.text = item.title
                movieRating.text = item.rate.toString()
            }
        }

    }

    inner class YearViewHolder(itemView: View) : BaseListViewHolder(itemView) {
        override fun bind(item: ListItem) {
            item as YearItem
            with(itemView) {
                tvDate.text = item.year.toString()
            }
        }

    }

}