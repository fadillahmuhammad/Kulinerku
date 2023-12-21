package com.dicoding.kulinerku.model

import com.dicoding.kulinerku.R

data class Restaurant(
    val id: Int,
    val image: Int,
    val name: String,
    val rate: String,
    val distance: String,
    val address: String,
    val price: String,
)

val dummyRestaurant = listOf(
    Restaurant(
        1,
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Dadeng",
        "4.5/5",
        "3.8",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat",
        "Rp. 100.000 - Rp. 200.000 /orang"
    ),
    Restaurant(
        2,
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Dadang",
        "4.3/5",
        "3.2",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat",
        "Rp. 100.000 - Rp. 200.000 /orang"
    ),
    Restaurant(
        3,
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Syam",
        "4.1/5",
        "3.5",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat",
        "Rp. 50.000 - Rp. 100.000 /orang"
    ),
    Restaurant(
        4,
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Adam",
        "4.4/5",
        "3.5",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Kec. Lengkong, Kota Bandung, Jawa Barat, dadiw dniadiw dniawndi dniwand ndiwad  dniwan  ndiwandi i diwadiwadn niwandai",
        "Rp. 100.000 - Rp. 200.000 /orang"
    ),
)