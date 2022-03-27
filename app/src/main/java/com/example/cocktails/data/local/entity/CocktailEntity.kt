package com.example.cocktails.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cocktails.domain.model.CocktailInfos

@Entity
data class CocktailEntity(
    val drinkName: String,
    val glass: String,
    val imageSource: String,
    val ingredient: String?,
    val ingredient2: String?,
    val ingredient3: String?,
    val ingredient4: String?,
    val ingredient5: String?,
    val ingredient6: String?,
    val ingredient7: String?,
    val ingredient8: String?,
    val ingredient9: String?,
    val ingredient10: String?,
    val ingredient11: String?,
    val ingredient12: String?,
    val ingredient13: String?,
    val ingredient14: String?,
    val ingredient15: String?,
    val instructions: String,
    @PrimaryKey(autoGenerate = true) val id: String? = null
) {
    fun toCocktailInfos() : CocktailInfos {
        return CocktailInfos(
            drinkName = drinkName,
            glass = glass,
            imageSource = imageSource,
            ingredient = ingredient,
            ingredient2 = ingredient2,
            ingredient3 = ingredient3,
            ingredient4 = ingredient4,
            ingredient5 = ingredient5,
            ingredient6 = ingredient6,
            ingredient7 = ingredient7,
            ingredient8 = ingredient8,
            ingredient9 = ingredient9,
            ingredient10 = ingredient10,
            ingredient11 = ingredient11,
            ingredient12 = ingredient12,
            ingredient13 = ingredient13,
            ingredient14 = ingredient14,
            ingredient15 = ingredient15,
            instructions = instructions
        )
    }
}
