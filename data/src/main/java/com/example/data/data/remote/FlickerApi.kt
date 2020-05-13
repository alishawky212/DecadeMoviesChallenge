package com.example.data.data.remote

import com.example.data.BuildConfig
import com.example.data.model.PhotosWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickerApi {
    @GET("services/rest/")
    fun movieImagesApi(
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") key: String = BuildConfig.API_KEY,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") callback: Int = 1,
        @Query("text") searchQuery: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 10
    ): Single<PhotosWrapper>
}