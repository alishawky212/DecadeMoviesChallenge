package com.example.decademovieschallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.decademovieschallenge.R
import com.example.decademovieschallenge.model.MovieItem
import com.example.decademovieschallenge.model.UiState
import com.example.decademovieschallenge.ui.adapter.EndlessRecyclerViewScrollListener
import com.example.decademovieschallenge.ui.adapter.PhotosAdapter
import com.example.decademovieschallenge.viewmodels.MovieDetailViewModel
import com.example.decademovieschallenge.viewmodels.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject


class DetailFragment : Fragment() {


    private lateinit var movieItem: MovieItem

    @Inject
    lateinit var factory: ViewModelFactory

    @Inject
    lateinit var adapter: PhotosAdapter

    private lateinit var viewModel: MovieDetailViewModel

    private lateinit var endlessRecyclerViewScrollListener: EndlessRecyclerViewScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, factory).get(MovieDetailViewModel::class.java)

        movieItem = DetailFragmentArgs.fromBundle(requireArguments()).movieItem

        viewModel.getMovieImages(movieItem.title)

        requireActivity().toolbar.title = movieItem.title
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movie_year.text = movieItem.year.toString()
        movie_cast.text = movieItem.cast.toString().replace("[", "").replace("]", "")
        movie_genres.text = movieItem.genres.toString().replace("[", "").replace("]", "")

        setupRecyclerView()
        viewModel.imagesLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                UiState.LoadingState -> {
                    photoPbar.isVisible = true
                    error_tv.isVisible = false
                }
                is UiState.SuccessState -> {
                    if (it.data.isEmpty()) {
                        showErrorScreen()
                    } else {
                        photoPbar.isVisible = false
                        error_tv.isVisible = false
                        photos_rv.isVisible = true
                        adapter.setImagesUrl(it.data)
                    }
                }
                is UiState.ErrorState -> {
                    showErrorScreen()
                }
            }
        })
    }

    private fun showErrorScreen() {
        photoPbar.isVisible = false
        error_tv.isVisible = true
        photos_rv.isVisible = false


    }

    private fun setupRecyclerView() {
        // Initialize the endlessRecyclerViewScrollListener so we don't NPE at onDestroyView
        val gridLayoutManager = GridLayoutManager(context, 2)
        photos_rv.layoutManager = gridLayoutManager
        photos_rv.itemAnimator = DefaultItemAnimator()
        endlessRecyclerViewScrollListener = object :
            EndlessRecyclerViewScrollListener(photos_rv.layoutManager as GridLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                viewModel.getMovieImages(movieItem.title, page)
            }
        }
        photos_rv.addOnScrollListener(endlessRecyclerViewScrollListener)
        photos_rv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        photos_rv.removeOnScrollListener(endlessRecyclerViewScrollListener)
    }

}
