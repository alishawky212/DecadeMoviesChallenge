package com.example.decademovieschallenge.di

import com.example.decademovieschallenge.MyApplication
import com.example.decademovieschallenge.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, NetworkModule::class,
        SchedulersModule::class, RepositoryModule::class,
        AppModule::class, DataSourceModule::class]
)
interface ApplicationComponent {
    fun inject(app: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun build(): ApplicationComponent
    }
}