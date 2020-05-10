package com.example.decademovieschallenge.di.modules

import android.app.Application
import com.example.decademovieschallenge.MyApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun application(app: MyApplication): Application
}