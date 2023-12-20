package com.dicoding.kulinerku.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.kulinerku.data.local.entity.RestaurantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurant_table")
    suspend fun getAllRestaurants(): List<RestaurantEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurant: RestaurantEntity)

    @Delete
    suspend fun delete(restaurant: RestaurantEntity)

    @Query("SELECT * FROM restaurant_table WHERE name = :name")
    suspend fun getRestaurantByName(name: String): RestaurantEntity
}