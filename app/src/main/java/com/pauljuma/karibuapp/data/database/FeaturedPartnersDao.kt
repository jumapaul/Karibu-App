package com.pauljuma.karibuapp.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pauljuma.karibuapp.data.model.local.FeaturedPartnersItem
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.data.model.local.MealType

@Dao
interface FeaturedPartnersDao {
    @Query("SELECT * FROM partner_name")
    fun getAllFeaturedPartnerItems(): List<FeaturedPartnersItem>

    @Upsert
    fun addToFeaturedPartnerItems(featuredPartnersItems: List<FeaturedPartnersItem>)

    @Query("SELECT * FROM meals WHERE mealType = :meal")
    fun getDrinks(meal: MealType): List<Meal>

    @Upsert
    fun addToDrinks(meal: List<Meal>)

    @Query("SELECT * FROM meals WHERE mealType = :meal")
    fun getBreakfast(meal: MealType): List<Meal>

    @Upsert
    fun addToBreakfast(meal: List<Meal>)

    @Query("SELECT * FROM meals WHERE mealType = :meal")
    fun getLunchAndDinner(meal: MealType): List<Meal>

    @Upsert
    fun addToLunchDinner(meal: List<Meal>)

    @Query("SELECT * FROM meals WHERE mealType = :meal")
    fun getAllDessertAndSlides(meal: MealType): List<Meal>

    @Upsert
    fun addToDessertAndSlides(meal: List<Meal>)

}