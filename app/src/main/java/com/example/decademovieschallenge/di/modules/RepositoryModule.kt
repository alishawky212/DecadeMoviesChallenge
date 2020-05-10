package com.example.decademovieschallenge.di.modules

import com.example.data.repository.MoviesRepositoryImpl
import com.example.data.repository.SearchRepositoryImpl
import com.example.domain.repository.MoviesRepository
import com.example.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindMovieRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository
}