package com.dicoding.kulinerku.model

import com.dicoding.kulinerku.R

data class Restaurant(
    val id: Int,
    val image: Int,
    val name: String,
    val rate: String,
    val address: String,
    val price: String,
    val street: String,
    val region: String,
    val subdistrict: String,
)

val dummyRestaurant = listOf(
    Restaurant(
        1,
        R.drawable.miekocok,
        "Mie Kocok Bandung Mang Dadeng",
        "4.5/5",
        "Jl. K.H. Ahmad Dahlan No.67, Turangga, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. K.H. Ahmad Dahlan No.67",
        "Turangga",
        "Lengkong"
    ),
    Restaurant(
        2,
        R.drawable.sme2,
        "Jenderal Kopi Nusantara Buwas",
        "4.46/5",
        "Jl. LLRE Martadinata No. 219, Riau, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. L. L. R.E. Martadinata No.219",
        "Cihapit",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        3,
        R.drawable.sme3,
        "Bonfire",
        "4.50/5",
        "Jl. LLRE Martadinata No. 137, Riau, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. L. L. R.E. Martadinata No.137",
        "Cihapit",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        4,
        R.drawable.sme4,
        "Roemah Legit",
        "4.31/5",
        "Jl. Embong No. 15, Naripan, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Embong No. 15",
        "Kb. Pisang",
        "Kec. Sumur Bandung"
    ),
    Restaurant(
        5,
        R.drawable.sme5,
        "HittoBitto",
        "4.33/5",
        "Jl. Trunojoyo No. 62, Trunojoyo, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. Trunojoyo No. 62",
        "Citarum",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        6,
        R.drawable.sme6,
        "Norge",
        "4.30/5",
        "Jl. Banda No. 4, Banda, Riau, Bandung",
        "Di bawah Rp. 50.000 /orang",
        "Jl. Banda No. 4",
        "Merdeka",
        "Kec. Sumur Bandung"
    ),
    Restaurant(
        7,
        R.drawable.sme7,
        "Myboo.Kit Cafe and Playground",
        "4.31/5",
        "Jl. Bukit Pakar Timur No. 2, Dago Atas, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Bukit Pakar Timur No. 2",
        "Ciburial",
        "Kec. Cimenyan"
    ),
    Restaurant(
        8,
        R.drawable.sme8,
        "Altero Bistronomie",
        "4.57/5",
        "Jl. Cipaganti No. 38, Cipaganti, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. Cipaganti No. 38",
        "Tamansari",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        9,
        R.drawable.sme9,
        "Hachi Grill",
        "4.62/5",
        "Jl. Prof. Dr. Sutami No. 56, Sarijadi, Bandung",
        "Di atas Rp. 200.000 /orang",
        "Jl. Prof. Dr. Sutami No. 56",
        "Sukarasa",
        "Kec. Sukasari"
    ),
    Restaurant(
        10,
        R.drawable.sme10,
        "Bellamie Boulangerie",
        "4.21/5",
        "Jl. Cihapit No. 37, Riau, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Cihapit No.35",
        "Cihapit",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        11,
        R.drawable.sme11,
        "Kumari",
        "4.26/5",
        "Jl. Bagusrangin No. 1, Dipatiukur, Bandung",
        "Di bawah Rp. 50.000 /orang",
        "Jl. Bagusrangin No.1",
        "Lebakgede",
        "Kec. Coblong"
    ),
    Restaurant(
        12,
        R.drawable.sme12,
        "Edelweiss Tea & Coffee House",
        "4.25/5",
        "Jl. Neglasari Dalam No. 7, Ciumbuleuit, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Neglasari Dalam No.7",
        "Ciumbuleuit",
        "Kec. Cidadap"
    ),
    Restaurant(
        13,
        R.drawable.sme13,
        "Kineruku",
        "4.43/5",
        "Jl. Hegarmanah No. 52, Setiabudhi, Bandung",
        "Di bawah Rp. 50.000 /orang",
        "Jl. Hegarmanah No. 52",
        "Hegarmanah",
        "Kec. Cidadap"
    ),
    Restaurant(
        14,
        R.drawable.sme14,
        "Ambrogio Patisserie",
        "4.19/5",
        "Jl. Banda No. 24, Banda, Riau, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Banda No.26",
        "Citarum",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        15,
        R.drawable.sme15,
        "Boja Eatery & Bar",
        "4.24/5",
        "Jl. Sumatera No. 21, Sumatera, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Sumatera No. 21",
        "Braga",
        "Kec. Sumur Bandung"
    ),
    Restaurant(
        16,
        R.drawable.sme16,
        "Fuller Smoke Town",
        "4.45/5",
        "Jl. Kidang Pananjung No. 5B, Dago Atas, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Kidang Pananjung No. 5B",
        "Dago",
        "Kec. Coblong"
    ),
    Restaurant(
        17,
        R.drawable.sme17,
        "Circolo",
        "4.60/5",
        "Jl. Sukajadi No. 198, Sukajadi, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. Sukajadi No. 198",
        "Pasteur",
        "Kec. Sukajadi"
    ),
    Restaurant(
        18,
        R.drawable.sme18,
        "Miss Bee Providore",
        "4.22/5",
        "Jl. Ranca Bentang No. 11A, Ciumbuleuit, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Rancabentang No.11A",
        "Ciumbuleuit",
        "Kec. Cidadap"
    ),
    Restaurant(
        19,
        R.drawable.sme19,
        "Justus Steakhouse",
        "4.22/5",
        "Jl. Cimanuk No. 8, Riau, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. Ir. H. Juanda No.59",
        "Tamansari",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        20,
        R.drawable.sme20,
        "Layung Coffee",
        "4.51/5",
        "Jl. Golf Raya No. A3, Arcamanik, Bandung",
        "Di bawah Rp. 50.000 /orang",
        "Jl. Golf Raya No.A3",
        "Cisaranten Bina Harapan",
        "Kec. Arcamanik"
    ),
    Restaurant(
        21,
        R.drawable.sme21,
        "Gormeteria",
        "4.16/5",
        "Jl. Pasir Kaliki No. 176, Pasir Kaliki, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Pasir Kaliki No.176",
        "Pasir Kaliki",
        "Kec. Cicendo"
    ),
    Restaurant(
        22,
        R.drawable.sme22,
        "Khoe Pek Goan Bloemenstad",
        "4.30/5",
        "Jl. Cendana No. 16, Riau, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Cendana No. 16",
        "Cihapit",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        23,
        R.drawable.sme23,
        "The Deli Bakes",
        "4.28/5",
        "Jl. Prof. Eyckman No. 26, Cipaganti, Bandung",
        "Di bawah Rp. 50.000 /orang",
        "Jl. Prof. Eyckman No. 26",
        "Pasteur",
        "Kec. Sukajadi"
    ),
    Restaurant(
        24,
        R.drawable.sme24,
        "One Eighty Coffee and Music",
        "4.14/5",
        "Jl. Ganeca No. 3, Dago Bawah, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Ganesa No.3",
        "Lb. Siliwangi",
        "Kec. Coblong"
    ),
    Restaurant(
        25,
        R.drawable.sme25,
        "Peach of Cake",
        "4.21/5",
        "Jl. Karangsari No. 17, Setiabudhi, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Karangsari No. 17",
        "Pasteur",
        "Kec. Sukajadi"
    ),
    Restaurant(
        26,
        R.drawable.sme26,
        "Gyumbox",
        "4.23/5",
        "Jl. Pasir Kaliki No. 25 - 27, Pasir Kaliki, Bandung",
        "Di bawah Rp. 50.000 /orang",
        "Jl. Pasir Kaliki No. 25 - 27",
        "Pasir Kaliki",
        "Kec. Andir"
    ),
    Restaurant(
        27,
        R.drawable.sme27,
        "Golden Bay Live Seafood Restaurant",
        "4.47/5",
        "Jl. LLRE Martadinata No. 187, Riau, Bandung",
        "Rp. 100.000 - Rp. 200.000 /orang",
        "Jl. LLRE Martadinata No. 187",
        "Cihapit",
        "Kec. Bandung Wetan"
    ),
    Restaurant(
        28,
        R.drawable.sme28,
        "Ekara Coffee & Eatery",
        "4.38/5",
        "Jl. Bukit Jarian No. 17, Ciumbuleuit, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Bukit Jarian No. 17",
        "Hegarmanah",
        "Kec. Cidadap"
    ),
    Restaurant(
        29,
        R.drawable.sme29,
        "The Restaurant - Hotel Padma",
        "4.40/5",
        "Jl. Ranca Bentang No. 56 - 58, Ciumbuleuit, Bandung",
        "Di atas Rp. 200.000 /orang",
        "Jl. Rancabentang No.56",
        "Ciumbuleuit",
        "Kec. Cidadap"
    ),
    Restaurant(
        30,
        R.drawable.sme30,
        "Badung People's Place",
        "4.28/5",
        "Jl. Dr. Cipto No. 3, Pasir Kaliki, Bandung",
        "Rp. 50.000 - Rp. 100.000 /orang",
        "Jl. Dr. Cipto No.3",
        "Pasir Kaliki",
        "Kec. Cicendo"
    )
)
