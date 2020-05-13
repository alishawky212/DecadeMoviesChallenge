package com.example.decademovieschallenge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.decademovieschallenge.di.modules.IO_SCHEDULER
import com.example.decademovieschallenge.mapper.MovieItemListMapper
import com.example.decademovieschallenge.mapper.SearchMovieMapper
import com.example.decademovieschallenge.model.ListItem
import com.example.decademovieschallenge.model.UiState
import com.example.domain.usecases.GetMoviesUseCase
import com.example.domain.usecases.SearchMoviesUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    @Named(value = IO_SCHEDULER) private val ioScheduler: Scheduler,
    private val moviesUiMapper: MovieItemListMapper,
    private val searchMovieMapper: SearchMovieMapper,
    private val searchMoviesUseCase: SearchMoviesUseCase

) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val movies = MutableLiveData<UiState<ListItem>>()

    val moviesLiveData: LiveData<UiState<ListItem>>
        get() = movies

    fun getMovies() {
        compositeDisposable.add(
            getMoviesUseCase.getMovies()
                .doOnSubscribe { movies.postValue(UiState.LoadingState) }
                .subscribeOn(ioScheduler)
                .observeOn(ioScheduler)
                .map {
                    moviesUiMapper.map(it)
                }.subscribe({
                    movies.postValue(UiState.SuccessState(it))
                }, {
                    movies.postValue(UiState.ErrorState(it.localizedMessage))
                })
        )
    }

    fun searchMovies(query: String) {
        compositeDisposable.add(
            searchMoviesUseCase.searchMovies(query)
                .doOnSubscribe { movies.postValue(UiState.LoadingState) }
                .subscribeOn(ioScheduler)
                .observeOn(ioScheduler)
                .map {
                    searchMovieMapper.map(it)
                }.subscribe({
                    movies.postValue(UiState.SuccessState(it))
                }, {
                    movies.postValue(UiState.ErrorState(it.localizedMessage))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}