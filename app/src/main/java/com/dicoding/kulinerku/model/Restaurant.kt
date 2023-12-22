package com.dicoding.kulinerku.model

import com.dicoding.kulinerku.R

data class Review(
    val id: Int,
    val restaurantId: Int,
    val text: String
)

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
    val reviews: List<Review>
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
        "Lengkong",
        listOf(
            Review(1, 1, "Rekomendasi banget! benar-benar mie kocok bandung ter enak"),
            Review(2, 1, "Tempatnya adem, mie kocoknya juga juara!")
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                3, 2, "Coffee Shop Bergaya Kolonial Modern\n" +
                        "Nyobain coffee shop ini karena dapet voucher pergi kuliner Dari depan tempat parkir cukup luas Begitu masuk area lobby kesan kolonialnya mulai terasa Begitu masuk ke bagian dalam ternyata tempatnya luas dan nuansa kolonial fancy dan modern bercampur jadi satu Pegawainya ramah banget dan tempatnya cocok banget untuk makan bareng keluarga Menu lumayan banyak sayangnya kita udah makan waktu ke sini Kami memesan \n\n" +
                        "1 Mille crepes tiramisu 58k\n" +
                        "Ini enak banget ga eneg dan manisnya pas Rasa tiramisunya lumayan strong\n\n" +
                        "2 Balabala 50k\n" +
                        "Ini porsinya besarbesar dan dapat 5 pcs balabala Saus cocolannya juga ensk tipe saus bangkok yang pedas asam manis\n\n" +
                        "3 Palm sugar latte 50k\n" +
                        "Kopinya g terlalu strong manis palm sugar berasa banget dan lebih ke milky rasanya\n\n" +
                        "4 Caffee latte 45k\n" +
                        "Kopi g terlalu strong rasa lebih ke creamy Makan di Tempatnya Jenderal Super Cozy Casual Dining disini\n"
            ),
            Review(
                4,
                2,
                "Sore ini aku nyoba mampir ke kafe Jenderal Kopi Nusantara Buwas nih\n" +
                        "Restoran fancy satu ini punya cukup banyak menu dari menu khas Indonesia sampai menumenu western Tempatnya luas sitting areanya juga banyak jadi gausah takut kehabisan tempat ya hihihih Oh ya disini ada area smoking non smoking dan private room start 15 juta  3 juta aja Untuk tempat sekelas jenderal sih cocok yaa karna dari interior furniture pelayanan dan menunya juga mewah banget Katanya private roomnya juga bisa kalian pake buat intimate event gitu Nyamaan\n" +
                        "Nah kali ini aku mutusin buat nyoba beberapa menu yaitu Creamy Farfalle Pasta Grilled Chicken with Creamy Sauce dan Jenderal Platter buat makanannya Sparkling Coffee untuk minumannya dan Mille Crepes buat dessert Biar gak penasaran sama rasanya ku review di bawah yaa\n\n" +
                        "1 Creamy Farfalle Pasta\n" +
                        "Makanan pertama yang ku coba itu pasta Sesuai namanya pasta yang ku coba ini pakai farfalle alias pasta yang punya bentuk mirip pita dan punya rasa creamymilky yang kuat meski bakal lebih enak kalau sedikit lebih asin Isinya sendiri ada pasta farfalle brokoli daging salmon dan potongan buah olive\n\n" +
                        "2 Grilled Chicken with Creamy Sauce\n" +
                        "Buat menu kedua aku pilih Grilled Chicken with Creamy Sauce yang daging ayamnya juicy banget Marinasinya juga pas\n" +
                        "Menu ini juga udah satu paket sama white sauce yang creamy tapi bakal lebih enak kalau rasa asinnya sedikit dikurangi Buat karbo dan sausnya ada french fries yang gendutgendut dan creamy spinach\n\n" +
                        "3 Jenderal Platter\n" +
                        "Aku juga pesan Jenderal Platter mix platter ala Jenderal Kopi Isinya cukup banyak ada fried fish fried chicken sosis panggang dan potato chips buat karbonya Di platter ini juga ada coleslaw salad kolwortel saus tartar dan chilli mayo\n\n" +
                        "4 Sparkling Coffee\n" +
                        "Sparkling Coffee ku pilih buat minumannya Ini tuh kopi yang rasa espressonya cukup light dan asamasam seger karena ada hint lemonnya Ada sensasi nyereng khas soda dari sparkling water juga\n\n" +
                        "5 Mille Crepes\n" +
                        "Terakhir aku nyicip dua rasa Mille Crepes nih buat desserrt Yang pertama ku coba tuh rasa taro Buat yang ini rasanya manis khas taro dan creamymilky banget\n" +
                        "Buat yang kedua aku coba yang rasa stroberi Aku pribadi lebih suka yang ini karena ada rasa asam dari stroberi seger Manisasamnya juga balance Mille crepes stroberi ini juga udah sepaket sama sorbett stroberi jadi bisa kita cocol deh mille crepesnya"
            ),
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(5, 3, "Beef Reef Fire hamburg steak  egg 12hours roasted brisket"),
            Review(6, 3, "Beef Reef enakkkkkk"),
            Review(
                7,
                3,
                "12 hours roasted brisket buat yg suka lemak aja kl ga sh pasti mabok "
            ),
            Review(8, 3, "Fire hamburg steak egg enakk"),
            Review(
                9,
                3,
                "Minuman nya biasa kl yg sunkist orange kurang manistawar asem ga manis ga"
            ),
            Review(10, 3, "kl deasert nya Cheesy Berries enakkk"),
            Review(
                11,
                3,
                "suasana nya enak cm kl siang kyny panas soalnya pake kipas angin aja Semua perfect texture"
            ),
            Review(
                12,
                3,
                "Tempatnya nyaman buat makan dengan keluarga dan romantis gitu bersih enakeun hangat terasa Variasi makanannya juga banyak menurutku spesialisnya tentu di per sapi an Aku pesen agak banyak sih makanannya tapi yang aku tangkep semua tekstur dagingnya is super lembut dan empuk sangat Dagingnya tuh dipotong dan dikunyah tanpa tenaga sama sekali ohya kentang gorengnya juga ini enak bangetsi Untuk bumbu kayaknya semua dia udah ada base bumbu bbq nya sendiri jadi kl makan hidangan utama 1 dengan yg lain rasanya mirip mirip gitu Lalu aku juga coba scallop nya ini enak seger dan ga amis sama sekali Oh aku coba waffle nya juga waffle nya enak Light crunchy dan buttery Untuk minuman aku coba irish coffee latte uwaaaah ini enak banget Kalo soal tekstur daging sapi sih disini wah deh empuk nya"
            ),
        )
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
        "Kec. Sumur Bandung",
        listOf(
            Review(
                13, 4, "Tempat kumpul keluarga yang nyaman\n" +
                        "Beberapa hari yang lalu aku nyobain nih makan di rumah legit yang ada di jalan embong nomor 15"
            ),
            Review(
                14,
                4,
                "1. Tempatnya nyaman banget cocok buat kumpul keluarga dan makan siang bareng rekan bisnis\n" +
                        "2. Pelayananya cepat makanan 10 menit sudah sampe di meja padahal pesen makanan berat\n" +
                        "3. Pelayanannya gercep dan bisa mgejawab semua pertanyaan kita mengenai menu makanannya\n" +
                        "4. Presentasi makanannya cantik\n" +
                        "5. Rasanya enak, sambel irengnya unik pake kluwek\n" +
                        "Kreasi batagornya juga enak, renyak masih terasa ikannya. Dan es Dogernya otentik mengingatkan rasa es doger waktu jaman kecil suka beli Restoran Nusantara Kaya Rempah. Restoran Nusantara kaya rempah baru nemu di Roemah Legit ini. Pernah kesini sendiri untuk makan siang dan sekarang senang bisa kembali lagi."
            ),
            Review(
                15,
                4,
                "Batagornya padat tahu dan ikannya cuco, bumbu kacangnya gurih manis enak"
            ),
            Review(
                16,
                4,
                "Tahu bading ini kayak tahu walik cuman menurutku lebih gede ini deh ukurannya digoreng kering rasanya sedep sambil dicocol sambel kecap"
            ),
            Review(
                17,
                4,
                "Tahu tjojol ini sama konsepnya kayak tahu bading yang beda sih tahunya aja hihi"
            ),
            Review(
                18,
                4,
                "Otakotaknya menurutku kurang berasa ikannya tapi sambel kacangnya enak bangettt"
            ),
            Review(
                19,
                4,
                "Nasi cikurnya ini enak banget masaaa cikurnya ga begitu nonjok gurih nasi dan kondimennya cuco semua"
            ),
            Review(
                20,
                4,
                "Pakeh peuteuy kesukaanku hahaa peuteuynya ini setengah matang jadi masih ada sensasi kriuknya pas dimakan ikan asinnya juga gede enak dimakan pake nasi anget"
            ),
            Review(
                21,
                4,
                "Nasi pandannya gurih dan wangi sekali udangnya gede sambelnya cukup pedes"
            ),
            Review(22, 4, "Karedoknya menurutku terlalu pedes jadi kurang menikmati heheu"),
            Review(
                23,
                4,
                "Nasi liwetnya gurih dan wangi juga kondimennya enakenak ga ada yang gagal"
            ),
            Review(24, 4, "Tumis kiciwisnya best sih kiciwisnya masih kriuk bumbunya pas"),
            Review(
                25,
                4,
                "Nasi tutug oncomnya enak juga oncomnya ini halus tercampur rata sama nasinya kondimennya banyak juga dan enakenak"
            ),
            Review(
                26,
                4,
                "Juku acar lolo ini gurame acar kuning guramenya ga amis acar kuning bumbunya lekoh banget ga begitu asem enakkk"
            ),
            Review(
                27,
                4,
                "Gadogado enak banget bumbunya tahunya padat ada lontongnya buat seporsi menurutku bumbunya kurang banyak"
            ),
            Review(
                28,
                4,
                "Terasi leumik ini kangkung pake bumbu terasi terasinya ga bau banget pas dimakan juga ga begitu terasi banget bumbunya pas"
            ),
            Review(
                29,
                4,
                "Soto ala nyonya ini soto mie ada lunpia perkedelnya gitu gurih dari kuah santan"
            ),
            Review(
                30,
                4,
                "Sambel dadaknya lumayan pedes yahh enakk ga bau terasi meski pake terasi"
            ),
            Review(31, 4, "Es cendolnya creamy manis dan segerr")
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                32,
                5,
                "Makanan di HittoBitto enak banget, porsinya juga pas. Harganya terjangkau, cocok buat hangout bareng teman."
            ),
            Review(
                33,
                5,
                "Suka banget sama suasana di HittoBitto. Tempatnya cozy dan nyaman buat nongkrong. Menu favoritku di sini adalah spaghetti."
            ),
            Review(
                34,
                5,
                "Pelayanannya ramah dan cepat. Makanan disajikan dengan rapi dan terasa segar. Pasti bakal balik lagi ke sini."
            ),
            Review(
                35,
                5,
                "HittoBitto jadi tempat favoritku buat ngumpul bareng teman. Rasa makanannya selalu konsisten enak."
            ),
            Review(
                36,
                5,
                "Restoran ini punya suasana yang unik, pas banget buat ngobrol santai sambil menikmati hidangan lezat."
            ),
        )
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
        "Kec. Sumur Bandung",
        listOf(
            Review(
                37,
                6,
                "Norge punya konsep cafe yang simpel tapi bikin betah. Kopinya juara, dan harga makanannya juga bersahabat."
            ),
            Review(
                38,
                6,
                "Sering banget nongkrong di Norge buat kerja atau sekadar baca buku. Kopi mereka wajib dicoba, paling enak di kelasnya."
            ),
            Review(
                39,
                6,
                "Tempatnya cozy dan asik, cocok buat yang suka nongkrong santai. Menu khasnya, Roti Bakar Norwegia, recommended banget!"
            ),
            Review(
                40,
                6,
                "Suasana di Norge enak buat yang mau kerja atau belajar. WiFi kencang dan makanan mereka enak-enak."
            ),
            Review(
                41,
                6,
                "Harga kopi di Norge lebih terjangkau dibanding tempat sejenis. Kopinya punya karakter yang kuat dan nikmat."
            ),
        )
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
        "Kec. Cimenyan",
        listOf(
            Review(
                42,
                7,
                "Myboo.Kit punya area playground yang seru buat anak-anak. Sambil menikmati kopi, bisa lihat anak main di sini."
            ),
            Review(
                43,
                7,
                "Tempatnya instagrammable banget, banyak spot foto yang lucu. Makanan di sini juga enak, pilihan menu untuk anak-anaknya pun cukup."
            ),
            Review(
                44,
                7,
                "Nyaman banget tempatnya, apalagi bagi yang suka kongkow sambil lihat anak main. Kopi mereka juga recommended."
            ),
            Review(
                45,
                7,
                "Myboo.Kit jadi pilihan utama buat kumpul keluarga. Anak-anak senang main di playground, sementara orang tua bisa santai menikmati kopi."
            ),
            Review(
                46,
                7,
                "Pertama kali datang ke sini karena penasaran dengan konsep cafe dan playground. Ternyata semua serba bagus, dari makanan sampai pelayanan."
            ),
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                47,
                8,
                "Altero Bistronomie adalah pilihan terbaik buat yang suka makan malam romantis. Suasana dan pelayanannya sangat memuaskan."
            ),
            Review(
                48,
                8,
                "Menu di Altero Bistronomie sangat beragam dan semuanya enak. Cocok buat acara spesial atau dinner date."
            ),
            Review(
                49,
                8,
                "Saya dan pasangan suka datang ke Altero Bistronomie buat merayakan momen spesial. Steak mereka juara!"
            ),
            Review(
                50,
                8,
                "Pertama kali mencoba Altero Bistronomie dan langsung jatuh hati. Suasana romantis, menu lengkap, dan pelayanan yang ramah."
            ),
            Review(
                51,
                8,
                "Restoran ini sukses menciptakan atmosfer yang romantis. Harganya sebanding dengan kualitas makanan dan layanan yang diberikan."
            ),
        )
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
        "Kec. Sukasari",
        listOf(
            Review(
                52,
                9,
                "Hachi Grill menjadi pilihan favoritku untuk makan malam. Sushi dan grill-nya selalu fresh dan lezat."
            ),
            Review(
                53,
                9,
                "Makanan di Hachi Grill selalu terasa autentik. Sushi dan sashimi-nya rekomendasi banget buat pecinta masakan Jepang."
            ),
            Review(
                54,
                9,
                "Suasana di Hachi Grill sangat cozy, cocok buat makan bersama keluarga atau teman. Sushi-nya selalu fresh dan enak."
            ),
            Review(
                55,
                9,
                "Hachi Grill punya pilihan menu yang beragam, dari sushi hingga grill. Harganya juga cukup bersahabat."
            ),
            Review(
                56,
                9,
                "Selalu puas dengan makanan di Hachi Grill. Tempatnya bersih, pelayanannya ramah, dan makanannya selalu fresh."
            ),
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                57,
                10,
                "Bellamie Boulangerie punya suasana yang nyaman untuk ngopi santai. Roti dan kue-kue mereka selalu freshly baked."
            ),
            Review(
                58,
                10,
                "Suka banget sama roti dan kue di Bellamie Boulangerie. Tempatnya cozy, pas buat nongkrong sambil menikmati hidangan manis."
            ),
            Review(
                59,
                10,
                "Harga di Bellamie Boulangerie cukup terjangkau untuk kualitas roti dan kue yang mereka tawarkan. Pelayanan juga oke."
            ),
            Review(
                60,
                10,
                "Tempat favorit untuk brunch! Bellamie Boulangerie selalu menyajikan roti dan kue yang lezat. Recommended!"
            ),
            Review(
                61,
                10,
                "Suasana di Bellamie Boulangerie sangat homey, membuat saya betah berlama-lama. Pilihan roti dan kuenya beragam dan enak."
            ),
        )
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
        "Kec. Coblong",
        listOf(
            Review(
                62,
                11,
                "Kumari jadi tempat langganan buat makan siang. Nasi liwetnya enak banget, dan harga makanannya terjangkau."
            ),
            Review(
                63,
                11,
                "Suka banget sama nasi liwet di Kumari. Waktu makan siang sering mampir ke sini karena porsinya pas dan rasanya nikmat."
            ),
            Review(
                64,
                11,
                "Nasi liwet Kumari selalu jadi favorit. Warna, aroma, dan rasanya sesuai dengan selera. Tempatnya juga bersih dan nyaman."
            ),
            Review(
                65,
                11,
                "Kumari cocok buat yang suka masakan tradisional. Nasi liwet dan menu lainnya selalu fresh dan lezat."
            ),
            Review(
                66,
                11,
                "Restoran ini adalah surga bagi pencinta nasi liwet. Pelayanan cepat, harga terjangkau, dan rasanya top markotop."
            ),
        )
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
        "Kec. Cidadap",
        listOf(
            Review(
                67,
                12,
                "Edelweiss Tea & Coffee House punya menu teh dan kopi yang beragam. Suasana tenang dan nyaman buat ngobrol santai."
            ),
            Review(
                68,
                12,
                "Tempat ini jadi favorit buat ngopi sore. Teh dan kopi di Edelweiss Tea & Coffee House selalu menyegarkan."
            ),
            Review(
                69,
                12,
                "Suka banget sama suasana vintage di Edelweiss Tea & Coffee House. Teh dan kopi mereka selalu nikmat, dan harga terjangkau."
            ),
            Review(
                70,
                12,
                "Edelweiss Tea & Coffee House punya playlist musik yang asik. Cocok buat yang suka nongkrong sambil menikmati minuman."
            ),
            Review(
                71,
                12,
                "Tempat ini cocok buat pecinta teh dan kopi. Pilihan menu di Edelweiss Tea & Coffee House lengkap dan berkualitas."
            ),
        )
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
        "Kec. Cidadap",
        listOf(
            Review(
                72,
                13,
                "Kineruku adalah tempat yang cozy buat pecinta buku. Makanan ringan dan kopi mereka enak, cocok buat nongkrong sambil membaca."
            ),
            Review(
                73,
                13,
                "Suka banget atmosfer di Kineruku. Buku, kopi, dan kue-kue mereka bikin betah berlama-lama."
            ),
            Review(
                74,
                13,
                "Makanan di Kineruku selalu fresh dan lezat. Cocok buat yang suka baca buku sambil menikmati suasana yang tenang."
            ),
            Review(
                75,
                13,
                "Pertama kali datang ke Kineruku karena suka membaca. Ternyata makanan dan minumannya juga enak-enak."
            ),
            Review(
                76,
                13,
                "Kineruku punya konsep yang unik. Buku yang banyak dan makanan yang lezat membuat tempat ini jadi favorit saya."
            ),
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                77,
                14,
                "Ambrogio Patisserie jadi pilihan terbaik buat pecinta kue dan pastry. Suasana cafe-nya juga nyaman."
            ),
            Review(
                78,
                14,
                "Suka banget sama kue di Ambrogio Patisserie. Rasanya autentik dan bikin ketagihan."
            ),
            Review(
                79,
                14,
                "Tempatnya cocok buat nongkrong sambil menikmati kue-kue premium. Harga sebanding dengan kualitas."
            ),
            Review(
                80,
                14,
                "Kue di Ambrogio Patisserie selalu fresh dan lezat. Pilihan menu juga beragam dan menggugah selera."
            ),
            Review(
                81,
                14,
                "Ambrogio Patisserie adalah surganya para pecinta kue. Setiap gigitan rasanya memikat lidah."
            ),
        )
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
        "Kec. Sumur Bandung",
        listOf(
            Review(
                82,
                15,
                "Boja Eatery & Bar punya menu makanan dan minuman yang enak. Suasana di sini juga cozy buat hangout."
            ),
            Review(
                83,
                15,
                "Makanan di Boja Eatery & Bar selalu segar dan lezat. Tempatnya asik buat kumpul-kumpul bareng teman."
            ),
            Review(
                84,
                15,
                "Cocok buat yang suka live music. Boja Eatery & Bar punya suasana yang seru buat hangout malam."
            ),
            Review(
                85,
                15,
                "Boja Eatery & Bar punya pilihan menu yang variatif. Harganya juga cukup terjangkau."
            ),
            Review(
                86,
                15,
                "Suasana di Boja Eatery & Bar selalu ramai dan seru. Makanan dan minuman di sini recommended."
            ),
        )
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
        "Kec. Coblong",
        listOf(
            Review(
                87,
                16,
                "Fuller Smoke Town adalah tempat yang cocok buat pecinta barbecue. Dagingnya juicy dan bumbunya meresap."
            ),
            Review(
                88,
                16,
                "Rasanya puas setiap kali mampir ke Fuller Smoke Town. Barbecue mereka selalu enak dan cocok di lidah."
            ),
            Review(
                89,
                16,
                "Barbecue di Fuller Smoke Town pilihan terbaik buat yang suka cita rasa asap dan manis."
            ),
            Review(
                90,
                16,
                "Tempat ini jadi favorit buat ngopi sambil menikmati barbecue. Suasana dan musiknya pas banget."
            ),
            Review(
                91,
                16,
                "Fuller Smoke Town adalah surganya penggemar barbecue. Dagingnya lembut dan bumbunya pas di lidah."
            ),
        )
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
        "Kec. Sukajadi",
        listOf(
            Review(
                92,
                17,
                "Circolo punya menu pasta yang lezat. Tempatnya romantis buat dinner bersama pasangan."
            ),
            Review(
                93,
                17,
                "Suka banget sama pasta di Circolo. Rasanya otentik dan porsi makanannya pas."
            ),
            Review(
                94,
                17,
                "Tempatnya cozy buat dinner romantis. Suasana di Circolo sangat mengesankan."
            ),
            Review(
                95,
                17,
                "Circolo selalu jadi pilihan untuk makan malam bersama keluarga. Harga dan rasa makanan sebanding."
            ),
            Review(
                96,
                17,
                "Pertama kali datang karena suka pasta. Ternyata di Circolo suasana dan pelayanannya juga oke."
            ),
        )
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
        "Kec. Cidadap",
        listOf(
            Review(
                97,
                18,
                "Miss Bee Providore cocok buat yang suka brunch. Menu sarapan dan kopi di sini enak dan bervariasi."
            ),
            Review(
                98,
                18,
                "Tempatnya asik buat ngopi sore. Miss Bee Providore punya kue-kue yang lezat."
            ),
            Review(
                99,
                18,
                "Suka banget sama konsep cafe-nya Miss Bee Providore. Makanan dan minuman di sini selalu fresh."
            ),
            Review(
                100,
                18,
                "Miss Bee Providore jadi favorit buat brunch. Suasana dan menu di sini instagramable."
            ),
            Review(
                101,
                18,
                "Setiap kali mampir ke Miss Bee Providore, selalu puas dengan makanan dan pelayanannya."
            ),
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                102,
                19,
                "Justus Steakhouse punya steak yang juicy dan lezat. Cocok buat yang suka daging panggang."
            ),
            Review(
                103,
                19,
                "Suka banget sama pilihan steak di Justus Steakhouse. Rasanya selalu konsisten enak."
            ),
            Review(
                104,
                19,
                "Tempatnya cocok buat dinner romantis. Justus Steakhouse jadi pilihan favorit untuk steak."
            ),
            Review(
                105,
                19,
                "Suasana di Justus Steakhouse sangat nyaman buat dinner bersama keluarga. Pelayanannya juga ramah."
            ),
            Review(
                106,
                19,
                "Justus Steakhouse selalu jadi pilihan utama kalau lagi pengen makan steak. Recommended!"
            ),
        )
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
        "Kec. Arcamanik",
        listOf(
            Review(
                107,
                20,
                "Layung Coffee adalah tempat yang cozy buat ngopi. Harga kopi di sini terjangkau dan rasanya mantap."
            ),
            Review(
                108,
                20,
                "Suka banget sama suasana di Layung Coffee. Kopi mereka selalu freshly brewed dan nikmat."
            ),
            Review(
                109,
                20,
                "Tempat ini jadi langganan buat ngopi sore. Layung Coffee punya pilihan kopi yang beragam."
            ),
            Review(110, 20, "Suasana di Layung")
        )
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
        "Kec. Cicendo",
        listOf(
            Review(
                111,
                21,
                "Gormeteria adalah tempat yang cocok buat hangout. Pilihan menu di sini banyak dan harganya terjangkau."
            ),
            Review(
                112,
                21,
                "Suka dengan konsep dan dekorasi interior Gormeteria. Suasana santai dan nyaman untuk nongkrong bersama teman."
            ),
            Review(
                113,
                21,
                "Menu makanan di Gormeteria enak-enak dan harganya ramah di kantong. Pelayanannya juga baik dan responsif."
            ),
            Review(
                114,
                21,
                "Tempat yang cozy buat ngobrol santai sambil menikmati kopi atau makanan ringan di Gormeteria."
            ),
            Review(
                115,
                21,
                "Gormeteria jadi pilihan favorit buat makan siang. Rasanya enak dan porsinya cukup memuaskan."
            ),
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                116,
                22,
                "Khoe Pek Goan Bloemenstad adalah restoran dengan konsep unik. Suasana dan dekorasinya Instagramable banget."
            ),
            Review(
                117,
                22,
                "Pernah mencoba masakan di Khoe Pek Goan Bloemenstad dan puas dengan rasanya. Layanan yang ramah membuat kunjungan semakin menyenangkan."
            ),
            Review(
                118,
                22,
                "Tempatnya asik buat kumpul bersama teman. Makanannya enak dan harganya cukup terjangkau."
            ),
            Review(
                119,
                22,
                "Keren banget konsep Khoe Pek Goan Bloemenstad, sangat berbeda dari restoran lain. Cocok buat yang suka eksplorasi kuliner."
            ),
            Review(
                120,
                22,
                "Menu makanan di Khoe Pek Goan Bloemenstad banyak yang unik dan enak. Layanan dan suasana restoran juga memuaskan."
            ),
        )
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
        "Kec. Sukajadi",
        listOf(
            Review(
                121,
                23,
                "The Deli Bakes punya pilihan roti dan kue yang lezat. Tempatnya cozy untuk nongkrong sambil ngopi."
            ),
            Review(
                122,
                23,
                "Kue dan roti di The Deli Bakes selalu fresh dan menggugah selera. Pelayanannya juga ramah."
            ),
            Review(
                123,
                23,
                "Pertama kali mencoba kue di The Deli Bakes dan langsung suka. Tempatnya juga Instagramable buat foto-foto."
            ),
            Review(
                124,
                23,
                "Rasa kue di The Deli Bakes bervariasi dan unik. Cocok buat pecinta kue dan roti."
            ),
            Review(
                125,
                23,
                "Suka suasana yang tenang di The Deli Bakes. Menu kue dan rotinya selalu menggoda untuk dicoba."
            ),
        )
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
        "Kec. Coblong",
        listOf(
            Review(
                126,
                24,
                "One Eighty Coffee and Music jadi tempat favorit buat ngopi. Suasana yang cozy dan musik yang enak membuat betah lama-lama di sini."
            ),
            Review(
                127,
                24,
                "Tempatnya asik buat ngobrol sambil menikmati kopi. One Eighty Coffee and Music selalu punya playlist musik yang oke."
            ),
            Review(
                128,
                24,
                "Kopi di One Eighty Coffee and Music selalu fresh dan rasanya pas di lidah. Pelayanan juga baik."
            ),
            Review(
                129,
                24,
                "Koleksi buku di One Eighty Coffee and Music membuat tempat ini cocok untuk yang suka baca buku sambil ngopi."
            ),
            Review(
                130,
                24,
                "One Eighty Coffee and Music punya suasana yang cozy dan nyaman. Tempatnya bersih dan pelayanannya ramah."
            ),
        )
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
        "Kec. Sukajadi",
        listOf(
            Review(
                131,
                25,
                "Peach of Cake punya koleksi kue yang lezat dan unik. Pilihan menu di sini cocok untuk pecinta kue."
            ),
            Review(
                132,
                25,
                "Suasana di Peach of Cake nyaman untuk ngobrol santai. Rasa kue dan minumannya selalu konsisten enak."
            ),
            Review(
                133,
                25,
                "Kue di Peach of Cake selalu terlihat fresh dan menggiurkan. Tempat yang pas untuk ngopi sambil menikmati kue."
            ),
            Review(
                134,
                25,
                "Menu di Peach of Cake banyak variasi dan rasanya selalu memuaskan. Pelayanan juga ramah dan cepat."
            ),
            Review(
                135,
                25,
                "Tempatnya Instagramable, cocok buat yang suka foto-foto. Peach of Cake jadi tempat yang tepat buat nongkrong santai."
            ),
        )
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
        "Kec. Andir",
        listOf(
            Review(
                136,
                26,
                "Gyumbox menyajikan masakan Jepang yang enak dengan harga terjangkau. Pilihan menu dan rasa makanannya memuaskan."
            ),
            Review(
                137,
                26,
                "Suka banget sama ramen di Gyumbox, rasanya pas dan kuahnya gurih. Harganya juga bersahabat."
            ),
            Review(
                138,
                26,
                "Tempatnya bersih dan pelayanan di Gyumbox cepat. Sushi dan sashimi di sini selalu fresh."
            ),
            Review(
                139,
                26,
                "Gyumbox jadi tempat langganan buat makan siang. Terutama suka dengan donburi dan bento box-nya."
            ),
            Review(
                140,
                26,
                "Pilihan menu di Gyumbox cukup beragam, mulai dari sushi, ramen, hingga donburi. Cocok buat penggemar masakan Jepang."
            ),
        )
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
        "Kec. Bandung Wetan",
        listOf(
            Review(
                141,
                27,
                "Golden Bay Live Seafood Restaurant tempat yang tepat buat pecinta makanan laut. Hidangan seafoodnya selalu fresh."
            ),
            Review(
                142,
                27,
                "Suka dengan konsep live seafood di Golden Bay, bisa pilih langsung dari akuarium. Rasa makanan lautnya juga enak."
            ),
            Review(
                143,
                27,
                "Pernah mencoba lobster di Golden Bay, rasanya luar biasa. Pelayanan yang ramah membuat pengalaman makan lebih menyenangkan."
            ),
            Review(
                144,
                27,
                "Harga di Golden Bay memang lebih tinggi, tapi sebanding dengan kualitas seafood yang disajikan."
            ),
            Review(
                145,
                27,
                "Golden Bay jadi pilihan buat makan spesial bersama keluarga. Suasana restoran juga nyaman untuk acara keluarga."
            ),
        )
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
        "Kec. Cidadap",
        listOf(
            Review(
                146,
                28,
                "Ekara Coffee & Eatery punya kopi yang nikmat dan harga terjangkau. Tempatnya asik buat nongkrong santai."
            ),
            Review(
                147,
                28,
                "Kopi di Ekara Coffee & Eatery selalu fresh, dan variasi makanan ringan di sini enak-enak."
            ),
            Review(
                148,
                28,
                "Suasana di Ekara Coffee & Eatery cozy dan nyaman. Cocok buat yang suka bekerja sambil ngopi."
            ),
            Review(
                149,
                28,
                "Makanan di Ekara Coffee & Eatery punya cita rasa yang unik. Harga terjangkau dengan porsi yang cukup."
            ),
            Review(
                150,
                28,
                "Ekara Coffee & Eatery adalah tempat yang pas buat nongkrong bareng teman atau keluarga. Pelayanan ramah dan cepat."
            ),
        )
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
        "Kec. Cidadap",
        listOf(
            Review(
                151,
                29,
                "The Restaurant di Hotel Padma jadi tempat makan yang mewah. Hidangan dan presentasinya luar biasa."
            ),
            Review(
                152,
                29,
                "Suka suasana elegan di The Restaurant - Hotel Padma. Cocok untuk makan malam romantis."
            ),
            Review(
                153,
                29,
                "Pernah mencoba steak di The Restaurant, rasanya juicy dan sempurna. Pelayanan dan suasana restoran sangat memuaskan."
            ),
            Review(
                154,
                29,
                "Harga di The Restaurant memang lebih tinggi, tapi kualitas makanan dan pengalaman makan yang didapat sebanding."
            ),
            Review(
                155,
                29,
                "The Restaurant - Hotel Padma adalah tempat yang pas untuk makan bersama pasangan atau acara spesial."
            ),
        )
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
        "Kec. Cicendo",
        listOf(
            Review(
                156,
                30,
                "Badung People's Place punya menu masakan Indonesia yang lezat. Suasana restoran juga nyaman dan bersahabat."
            ),
            Review(
                157,
                30,
                "Makan di Badung People's Place selalu bikin kangen masakan rumah. Porsinya pas dan rasanya enak."
            ),
            Review(
                158,
                30,
                "Suka dengan konsep warung makan di Badung People's Place. Hidangan nasi goreng dan mie gorengnya juara."
            ),
            Review(
                159,
                30,
                "Pernah mencoba soto Betawi di Badung People's Place, rasanya otentik dan bikin nagih."
            ),
            Review(
                160,
                30,
                "Badung People's Place jadi pilihan kalau lagi pengen makan masakan Indonesia yang autentik. Harga juga bersahabat."
            ),
        )
    )
)

