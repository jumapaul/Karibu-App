package com.pauljuma.karibuapp.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_item")
data class CartItemData(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val productId: String,
    var quantity: Int
)