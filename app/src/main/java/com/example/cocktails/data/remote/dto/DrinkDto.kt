package com.example.cocktails.data.remote.dto

import com.example.cocktails.data.local.entity.CocktailEntity

data class DrinkDto(
    val dateModified: String,
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrink: String,
    val strDrinkAlternate: String?,
    val strDrinkThumb: String,
    val strGlass: String,
    val strIBA: String,
    val strImageAttribution: String,
    val strImageSource: String,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strInstructions: String,
    val strInstructionsDE: String?,
    val strInstructionsES: String?,
    val strInstructionsFR: String?,
    val strInstructionsIT: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strTags: String,
    val strVideo: String?
) {
    fun toCocktailEntity(): CocktailEntity {
        return CocktailEntity(
            drinkName = strDrink,
            glass = strGlass,
            imageSource = strImageSource,
            ingredient = toIngredient(strIngredient1, strMeasure1),
            ingredient2 = toIngredient(strIngredient2, strMeasure2),
            ingredient3 = toIngredient(strIngredient3, strMeasure3),
            ingredient4 = toIngredient(strIngredient4, strMeasure4),
            ingredient5 = toIngredient(strIngredient5, strMeasure5),
            ingredient6 = toIngredient(strIngredient6, strMeasure6),
            ingredient7 = toIngredient(strIngredient7, strMeasure7),
            ingredient8 = toIngredient(strIngredient8, strMeasure8),
            ingredient9 = toIngredient(strIngredient9, strMeasure9),
            ingredient10 = toIngredient(strIngredient10, strMeasure10),
            ingredient11 = toIngredient(strIngredient11, strMeasure11),
            ingredient12 = toIngredient(strIngredient12, strMeasure12),
            ingredient13 = toIngredient(strIngredient13, strMeasure13),
            ingredient14 = toIngredient(strIngredient14, strMeasure14),
            ingredient15 = toIngredient(strIngredient15, strMeasure15),
            instructions = strInstructions
        )
    }

    private fun toIngredient(ingredient: String?, measure: String?): String? {
        if (ingredient.isNullOrEmpty() || measure.isNullOrEmpty()) return null
        return "$ingredient $measure"
    }
}