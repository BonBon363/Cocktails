package com.example.cocktails.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cocktails.data.local.entity.CocktailEntity

@Dao
interface CocktailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktailInfos(infos: List<CocktailEntity>)

    @Query("DELETE FROM cocktailentity WHERE drinkName IN (:drinkName)")
    suspend fun deleteCocktailInfos(drinkName: List<String>)

    @Query("SELECT * FROM cocktailentity WHERE drinkName LIKE '%' || :drinkName || '%'")
    suspend fun getCocktailInfos(drinkName: String): List<CocktailEntity>
}