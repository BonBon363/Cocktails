package com.example.cocktails.data.remote

import com.example.cocktails.data.remote.dto.DrinkDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    companion object {
        const val BASE_URL = "https://www.thecocktaildb.com"
    }

    @GET("/api/json/v1/1/search.php")
    suspend fun getCocktail(
        @Query ("s") cocktailName: String
    ): List<DrinkDto>
}