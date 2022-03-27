package com.example.cocktails.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocktails.data.local.dao.CocktailDao
import com.example.cocktails.data.local.entity.CocktailEntity

@Database(
    entities = [CocktailEntity::class],
    version = 1
)
abstract class CocktailDatabase: RoomDatabase() {

    abstract val dao: CocktailDao
}