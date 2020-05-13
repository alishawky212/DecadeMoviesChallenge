package com.example.decademovieschallenge.di.builders

import com.example.decademovieschallenge.ui.DetailFragment
import com.example.decademovieschallenge.ui.MasterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {
    @ContributesAndroidInjector
    fun bindMasterFragment(): MasterFragment

    @ContributesAndroidInjector
    fun bindMovieDetailFragment(): DetailFragment
}