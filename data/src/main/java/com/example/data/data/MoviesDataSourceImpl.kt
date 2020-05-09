package com.example.data.data

import android.app.Application
import com.example.data.model.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import javax.inject.Inject

class MoviesDataSourceImpl @Inject constructor(
    private val applicationContext: Application,
    private val gson: Gson
) : MoviesDataSource {
    override fun getMovies(): Single<List<Movie>> {
        return Single.create {
            try {
                val stream = applicationContext.assets.open("movies.json")
                val size: Int = stream.available()
                val buffer = ByteArray(size)
                stream.read(buffer)
                stream.close()
                val json = String(buffer)
                val movie = gson.fromJson<Movie>(json, object : TypeToken<Movie>() {}.type)
                it.onSuccess(listOf(movie))
            } catch (e: Exception) {
                it.onError(e)
            }
        }
    }
}