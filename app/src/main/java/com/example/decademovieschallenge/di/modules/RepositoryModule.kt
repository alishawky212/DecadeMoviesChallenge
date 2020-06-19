package com.example.decademovieschallenge.di.modules

import com.example.data.repository.MoviesRepositoryImpl
import com.example.data.repository.ImagesRepositoryImpl
import com.example.domain.repository.MoviesRepository
import com.example.domain.repository.ImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindMovieRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImpl: ImagesRepositoryImpl): ImagesRepository
}