package com.example.cocktails.data.repository

import com.example.cocktails.data.local.dao.CocktailDao
import com.example.cocktails.data.remote.CocktailApi
import com.example.cocktails.domain.model.CocktailInfos
import com.example.cocktails.domain.repository.ICocktailInfoRepository
import com.example.cocktails.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.withContext

class CocktailInfoRepository(
    private val api: CocktailApi,
    private val dao: CocktailDao
): ICocktailInfoRepository {

    private val cocktailInfos =
        MutableSharedFlow<Resource<List<CocktailInfos>>>(extraBufferCapacity = 1)

   override suspend fun setCocktailInfos(drinkName: String) {

        val localCocktailInfos = withContext(Dispatchers.IO) {
            dao.getCocktailInfos(drinkName).map { it.toCocktailInfos() }
        }

        withContext(Dispatchers.IO) {
            try {
                val remoteCocktailInfos = api.getCocktail(drinkName).map { it.toCocktailEntity() }
                if (!localCocktailInfos.isNullOrEmpty()) {
                    dao.deleteCocktailInfos(remoteCocktailInfos.map { it.drinkName })
                }
                dao.insertCocktailInfos(remoteCocktailInfos)
            } catch (e: Exception) {
                cocktailInfos.tryEmit(
                    Resource(
                        message = e.message
                    )
                )
            }
        }

        withContext(Dispatchers.IO) {
            cocktailInfos.tryEmit(
                Resource(
                    data = dao.getCocktailInfos(drinkName).map { it.toCocktailInfos() }
                )
            )
        }
    }

    override fun getCocktailInfos() = cocktailInfos.asSharedFlow()
}