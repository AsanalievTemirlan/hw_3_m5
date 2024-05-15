package com.example.hw_03_m5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("character")
    fun getCharacter(
        @Query("page") page: Int
    ): Call<CharactersResponse>


}