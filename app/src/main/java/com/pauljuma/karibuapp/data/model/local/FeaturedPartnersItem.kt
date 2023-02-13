package com.pauljuma.karibuapp.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("partner_name")
data class FeaturedPartnersItem(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val location: String,
    val imageUrl: String?
): java.io.Serializable