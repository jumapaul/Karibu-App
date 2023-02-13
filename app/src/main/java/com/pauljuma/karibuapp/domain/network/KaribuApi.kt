package com.pauljuma.karibuapp.domain.network

import com.pauljuma.karibuapp.data.model.local.FeaturedPartnersItem
import com.pauljuma.karibuapp.data.model.remote.MealResponse
import retrofit2.http.GET

interface KaribuApi {
    @GET("continents")
    suspend fun getFeaturedPartners(): List<FeaturedPartnersItem>

}