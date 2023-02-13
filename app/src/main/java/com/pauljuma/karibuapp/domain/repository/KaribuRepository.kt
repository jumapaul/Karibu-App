package com.pauljuma.karibuapp.domain.repository

import com.pauljuma.karibuapp.data.model.local.FeaturedPartnersItem
import com.pauljuma.karibuapp.data.database.AppDatabase
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.data.model.local.MealType
import com.pauljuma.karibuapp.domain.network.KaribuApiInstance
import com.pauljuma.karibuapp.domain.network.SectionApiInstance

class KaribuRepository(val db: AppDatabase) {

    suspend fun getPartners(): List<FeaturedPartnersItem> {

        val item = KaribuApiInstance.api.getFeaturedPartners()
        db.getFeaturedPartnerDao().addToFeaturedPartnerItems(item)
        return db.getFeaturedPartnerDao().getAllFeaturedPartnerItems()
    }

    suspend fun getDrinks(): List<Meal> {
        //Map to type drinks
        val drinks = SectionApiInstance.api.getDrinks().map { it.toMeal(MealType.DRINKS) }

        //Saving to the database
        db.getFeaturedPartnerDao().addToDrinks(drinks)

        //Retrieve from db
        return db.getFeaturedPartnerDao().getDrinks(MealType.DRINKS)
    }

    suspend fun getBreakfast(): List<Meal> {
        val breakfast = SectionApiInstance.api.getBreakfast().map { it.toMeal(MealType.BREAKFAST) }
        db.getFeaturedPartnerDao().addToBreakfast(breakfast)
        return db.getFeaturedPartnerDao().getBreakfast(MealType.BREAKFAST)
    }

    suspend fun getLunchAndDinner(): List<Meal> {
        val lunchDinner =
            SectionApiInstance.api.getLunchAndDinner().map { it.toMeal(MealType.LUNCHDINNER) }
        db.getFeaturedPartnerDao().addToLunchDinner(lunchDinner)
        return db.getFeaturedPartnerDao().getLunchAndDinner(MealType.LUNCHDINNER)
    }

    suspend fun getDessertsAndSlides(): List<Meal> {
        val desserts =
            SectionApiInstance.api.getDessertAndSlides().map { it.toMeal(MealType.DESSERTSLIDES) }
        db.getFeaturedPartnerDao().addToDessertAndSlides(desserts)
        return db.getFeaturedPartnerDao().getAllDessertAndSlides(MealType.DESSERTSLIDES)
    }

}