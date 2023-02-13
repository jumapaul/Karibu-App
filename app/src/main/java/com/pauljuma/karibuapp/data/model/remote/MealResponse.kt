package com.pauljuma.karibuapp.data.model.remote

import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.data.model.local.MealType

data class MealResponse(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int
) {
    fun toMeal(mealType: MealType): Meal {
        return Meal(id, name, imageUrl, price, mealType)
    }
}
