package com.pauljuma.karibuapp.domain.network

import com.pauljuma.karibuapp.data.model.remote.MealResponse
import retrofit2.http.GET

interface SectionApi {
    @GET("building")
    suspend fun getDrinks():List<MealResponse>

    @GET("ClassIdentity")
    suspend fun getBreakfast():List<MealResponse>

    @GET("Unit")
    suspend fun getLunchAndDinner(): List<MealResponse>

    @GET("Schedules")
    suspend fun getDessertAndSlides(): List<MealResponse>
}