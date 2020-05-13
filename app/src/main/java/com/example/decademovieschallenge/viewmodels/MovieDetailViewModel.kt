package com.example.decademovieschallenge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.decademovieschallenge.di.modules.IO_SCHEDULER
import com.example.decademovieschallenge.model.UiState
import com.example.domain.usecases.GetMovieImagesUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class MovieDetailViewModel @Inject constructor(
    @Named(value = IO_SCHEDULER) private val ioScheduler: Scheduler,
    private val useCase: GetMovieImagesUseCase
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val images = MutableLiveData<UiState<String>>()

    val imagesLiveData: LiveData<UiState<String>>
        get() = images


    fun getMovieImages(title: String, page: Int = 1) {
        compositeDisposable.add(
            useCase.getMovieImages(title, page)
                .doOnSubscribe {
                    images.postValue(UiState.LoadingState)
                }.subscribeOn(ioScheduler)
                .observeOn(ioScheduler)
                .subscribe({
                    images.postValue(UiState.SuccessState(it))
                }, {
                    images.postValue(UiState.ErrorState(it.localizedMessage))
                })
        )
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}