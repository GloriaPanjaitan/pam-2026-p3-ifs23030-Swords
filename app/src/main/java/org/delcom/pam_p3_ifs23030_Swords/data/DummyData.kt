package org.delcom.pam_p3_ifs23030_Swords.data

import org.delcom.pam_p3_ifs23030_Swords.R

object DummyData {
    fun getSwordsData(): List<SwordData> {
        return listOf(
            SwordData(
                nama = "Longsword Eropa",
                gambar = R.drawable.img_longsword_eropa, // Pastikan file gambar ada di res/drawable
                asal = "Eropa Tengah (Abad Pertengahan)",
                sejarah = "Populer antara abad ke-14 hingga ke-16, digunakan oleh ksatria sebagai senjata dua tangan yang serbaguna.",
                kelebihan = "Jangkauan luas, mampu menyerang dan bertahan dengan sangat efektif berkat 'cross-guard' yang besar.",
                faktaUnik = "Sering disebut sebagai 'Hand-and-a-Half Sword' karena bisa digunakan dengan satu atau dua tangan."
            ),
            SwordData(
                nama = "Zulfiqar Arab",
                gambar = R.drawable.img_zulfiqar_arab,
                asal = "Jazirah Arab",
                sejarah = "Pedang legendaris yang diberikan Nabi Muhammad SAW kepada Ali bin Abi Thalib. Menjadi simbol keberanian dalam sejarah Islam.",
                kelebihan = "Bentuk ujung yang bercabang dua memberikan kemampuan tebasan yang unik dan sangat mematikan.",
                faktaUnik = "Merupakan salah satu pedang paling ikonik di dunia Timur Tengah dan sering digambarkan dalam seni kaligrafi."
            ),
            SwordData(
                nama = "Sabre Eropa Timur",
                gambar = R.drawable.img_sabre_eropatimur,
                asal = "Eropa Timur (Hungaria/Polandia)",
                sejarah = "Dikembangkan untuk kebutuhan kavaleri (pasukan berkuda) guna melakukan serangan tebasan cepat.",
                kelebihan = "Bentuk bilah yang melengkung memudahkan prajurit menarik pedang saat melewati musuh tanpa tersangkut.",
                faktaUnik = "Menjadi dasar bagi pedang perwira militer modern di berbagai belahan dunia."
            ),
            SwordData(
                nama = "Jian Tiongkok",
                gambar = R.drawable.img_jian_tiongkok,
                asal = "Tiongkok Kuno",
                sejarah = "Dikenal sebagai 'Budayawan di antara Senjata', digunakan selama lebih dari 2.500 tahun di Tiongkok.",
                kelebihan = "Sangat ringan dan seimbang, dirancang untuk teknik tusukan presisi dan gerakan yang elegan.",
                faktaUnik = "Banyak digunakan dalam latihan bela diri Tai Chi untuk melatih fokus dan aliran energi."
            ),
            SwordData(
                nama = "Shamshir Persia",
                gambar = R.drawable.img_shamshir_persia,
                asal = "Persia (Iran)",
                sejarah = "Muncul pada abad ke-12, pedang ini memiliki lengkungan yang sangat ekstrem dibandingkan pedang lainnya.",
                kelebihan = "Sangat efektif untuk teknik 'draw-cut' (tebasan tarik) yang bisa menembus pakaian pelindung ringan.",
                faktaUnik = "Nama 'Shamshir' secara harfiah berarti 'cakar singa' dalam bahasa Persia."
            ),
            SwordData(
                nama = "Talwar India",
                gambar = R.drawable.img_talwar_india,
                asal = "India (Kekaisaran Mughal)",
                sejarah = "Pedang standar di anak benua India, sering kali memiliki hiasan yang sangat mewah pada bagian gagangnya.",
                kelebihan = "Gagang berbentuk piringan (disc pommel) memberikan genggaman yang sangat stabil saat menebas.",
                faktaUnik = "Bilahnya sering dibuat dari baja Wootz, yaitu baja legendaris India yang sangat kuat dan tajam."
            ),
            SwordData(
                nama = "Ulfberht Viking",
                gambar = R.drawable.img_ulfberht_viking,
                asal = "Skandinavia (Zaman Viking)",
                sejarah = "Pedang kelas atas yang dibuat dengan teknologi metalurgi rahasia yang jauh melampaui zamannya.",
                kelebihan = "Kandungan karbon yang murni membuatnya sangat kuat, elastis, dan tidak mudah patah dalam pertempuran.",
                faktaUnik = "Hanya pedang asli yang memiliki grafir nama '+VLFBERHT+' di bilahnya sebagai tanda kualitas."
            ),
            SwordData(
                nama = "Claymore Skotlandia",
                gambar = R.drawable.img_claymore_skotlandia,
                asal = "Skotlandia (Dataran Tinggi)",
                sejarah = "Senjata ikonik prajurit Highland Skotlandia saat melawan penjajahan, digunakan dengan dua tangan.",
                kelebihan = "Ukurannya yang raksasa memberikan daya hancur yang luar biasa terhadap zirah dan perisai lawan.",
                faktaUnik = "Nama 'Claymore' berasal dari bahasa Gaelic 'claidheamh-mòr' yang berarti 'pedang besar'."
            ),
            SwordData(
                nama = "Katana Jepang",
                gambar = R.drawable.img_katana_jepang,
                asal = "Jepang (Zaman Kamakura)",
                sejarah = "Senjata utama kelas Samurai, dibuat melalui proses pelipatan baja ribuan kali untuk membuang kotoran.",
                kelebihan = "Memiliki ketajaman tingkat mikroskopis dan struktur yang sangat keras namun fleksibel.",
                faktaUnik = "Memiliki 'hamon' atau garis pola unik pada bilah hasil dari proses pendinginan tanah liat."
            ),
            SwordData(
                nama = "Gladius Romawi",
                gambar = R.drawable.img_gladius_romawi,
                asal = "Kekaisaran Romawi",
                sejarah = "Senjata jarak dekat yang membantu tentara Romawi menaklukkan hampir seluruh dunia yang dikenal saat itu.",
                kelebihan = "Ukurannya yang pendek sangat efisien digunakan dalam formasi perisai rapat (testudo) untuk menusuk perut lawan.",
                faktaUnik = "Meskipun kecil, pedang ini dianggap sebagai 'pedang yang paling banyak membunuh orang' dalam sejarah kuno."
            )
        )
    }
}