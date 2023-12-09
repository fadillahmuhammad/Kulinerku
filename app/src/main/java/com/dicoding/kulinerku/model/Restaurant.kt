package com.dicoding.kulinerku.model

import com.dicoding.kulinerku.R

data class Restaurant(
    val image: Int,
    val name: String,
    val rate: String,
    val distance: String,
    val address: String,
    val isOpen: Boolean,
    val isFavorite: Boolean
)

val dummyRestaurant = listOf(
    Restaurant(
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Dadeng",
        "4.5",
        "3.8",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat",
        true,
        true
    ),
    Restaurant(
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Dadang",
        "4.3",
        "3.2",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat",
        true,
        true
    ),
    Restaurant(
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Syam",
        "4.1",
        "3.5",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat",
        true,
        true
    ),
    Restaurant(
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Adam",
        "4.4",
        "3.5",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat",
        true,
        true
    ),
)