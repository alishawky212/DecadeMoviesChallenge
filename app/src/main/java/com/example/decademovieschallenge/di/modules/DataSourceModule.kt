package com.example.decademovieschallenge.di.modules

import com.example.data.data.MovieImagesDataSource
import com.example.data.data.MovieImagesDataSourceImpl
import com.example.data.data.MoviesDataSource
import com.example.data.data.MoviesDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {
    @Binds
    fun bindMovieImagesDataSource(movieImagesDataSourceImpl: MovieImagesDataSourceImpl): MovieImagesDataSource

    @Binds
    fun bindMoviesDataSource(moviesDataSourceImpl: MoviesDataSourceImpl): MoviesDataSource
}