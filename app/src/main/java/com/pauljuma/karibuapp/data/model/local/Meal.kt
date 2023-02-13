package com.pauljuma.karibuapp.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("meals")
data class Meal(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int,
    val mealType: MealType
)
