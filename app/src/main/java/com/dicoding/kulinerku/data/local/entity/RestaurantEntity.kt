package com.dicoding.kulinerku.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val image: Int,
    val name: String,
    val rate: String,
    val distance: String,
    val address: String,
    val isOpen: Boolean,
)