package com.example.decademovieschallenge.ui

import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.decademovieschallenge.R
import com.example.decademovieschallenge.model.ListItem
import com.example.decademovieschallenge.model.UiState
import com.example.decademovieschallenge.ui.adapter.MoviesAdapter
import com.example.decademovieschallenge.viewmodels.MoviesViewModel
import com.example.decademovieschallenge.viewmodels.ViewModelFactory
import com.facebook.shimmer.Shimmer
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_master.*
import javax.inject.Inject


class MasterFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var moviesAdapter: MoviesAdapter

    private lateinit var viewModel: MoviesViewModel

    private var searchMenuItem: MenuItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MoviesViewModel::class.java]

        viewModel.getMovies()

        viewModel.moviesLiveData.observe(this, Observer {
            render(it)
        })

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMatchesRecyclerView()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        searchMenuItem = menu.findItem(R.id.app_bar_search)
        val search: SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView

        search.onQueryTextListener {
            if (it.isNullOrEmpty()) {
                viewModel.getMovies()
            } else {
                viewModel.searchMovies(it)
            }
        }

        search.setOnCloseListener {
            viewModel.getMovies()
            return@setOnCloseListener true
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.app_bar_search -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun render(it: UiState<ListItem>?) {
        when (it) {
            UiState.LoadingState -> {
                showLoading()
            }
            is UiState.SuccessState -> {
                stopLoading()
                showData(it.data)
            }
            is UiState.ErrorState -> {
                stopLoading()
                Toast.makeText(context, "There is an Issue", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLoading() {
        rcMovies.isVisible = false
        shimmer_view.isVisible = true
        val builder = Shimmer.AlphaHighlightBuilder()
        builder.setDuration(1250)
        builder.setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        shimmer_view.setShimmer(builder.build())
        shimmer_view.startShimmer()
    }

    private fun stopLoading() {
        shimmer_view.isVisible = false
        shimmer_view.stopShimmer()
        rcMovies.isVisible = true
    }

    private fun showData(items: List<ListItem>) {
        moviesAdapter.setData(items)
    }

    private fun initMatchesRecyclerView() {
        rcMovies.layoutManager = LinearLayoutManager(context)
        rcMovies.adapter = moviesAdapter
        val mDivider = ContextCompat.getDrawable(requireContext(), R.drawable.divider)
        val hItemDecoration = DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL
        )
        hItemDecoration.setDrawable(mDivider!!)
        rcMovies.addItemDecoration(hItemDecoration)
        runLayoutAnimation()
    }

    private fun runLayoutAnimation() = rcMovies.apply {
        layoutAnimation =
            AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom)
        scheduleLayoutAnimation()
        layoutAnimationListener = object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                layoutManager?.findViewByPosition(0)?.clearAnimation()
            }

            override fun onAnimationEnd(animation: Animation?) = Unit
            override fun onAnimationRepeat(animation: Animation?) = Unit
        }
    }


}

fun SearchView.onQueryTextListener(queryListener: (String) -> Unit) {
    return this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            queryListener(query)
            return true
        }

        override fun onQueryTextChange(newText: String): Boolean {
            queryListener(newText)
            return true
        }
    })
}