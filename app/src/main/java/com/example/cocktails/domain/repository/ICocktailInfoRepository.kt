package com.example.cocktails.domain.repository

import com.example.cocktails.domain.model.CocktailInfos
import com.example.cocktails.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ICocktailInfoRepository {

    suspend fun setCocktailInfos(drinkName: String)
    fun getCocktailInfos(): Flow<Resource<List<CocktailInfos>>>
}