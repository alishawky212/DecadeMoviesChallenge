package com.example.decademovieschallenge.di.modules

import androidx.lifecycle.ViewModel
import com.example.decademovieschallenge.di.ViewModelKey
import com.example.decademovieschallenge.viewmodels.MovieDetailViewModel
import com.example.decademovieschallenge.viewmodels.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    fun bindMainViewModel(moviesViewModel: MoviesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    fun bindDetailsViewModel(detailViewModel: MovieDetailViewModel): ViewModel
}