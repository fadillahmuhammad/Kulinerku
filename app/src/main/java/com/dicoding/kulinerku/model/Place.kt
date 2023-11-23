package com.dicoding.kulinerku.model

import com.dicoding.kulinerku.R

data class Place(
    val image: Int,
    val name: String,
    val rate: String,
)

val dummyPlace = listOf(
    Place(R.drawable.kiara_place, "Kiara Artha Park", "4.1"),
    Place(R.drawable.balaikota_place, "Taman Balaikota", "4.5"),
    Place(R.drawable.braga_place, "Braga", "4.3"),
    Place(R.drawable.lembang_wonderland_place, "Lembang Wonderland", "4.0"),
)