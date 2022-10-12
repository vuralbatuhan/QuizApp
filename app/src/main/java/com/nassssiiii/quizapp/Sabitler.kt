package com.nassssiiii.quizapp

object Sabitler{

    const val KULLANICI_ADI: String = "kullanıcı_adı"
    const val TOPLAM_SORU_SAYISI: String = "toplam_soru_sayısı"
    const val DOGRU_CEVAPLAR: String = "dogru_cevaplar"

    fun soruyuCagir(): ArrayList<Sorular>{
        val sorularListesi = ArrayList<Sorular>()

        //1. soru
        val soru1 = Sorular(1,"Türkiye'de 4 bölgede toprağı bulunan il hangisidir?",
        R.drawable.trbayrak,
            "Çankırı",
            "Bilecik",
            "Afyonkarahisar",
            "Bolu",
            2)

        sorularListesi.add(soru1)

        //2.soru
        val soru2 =Sorular(2,"Aşağıdaki bayrak hangi ülkenin bayrağıdır",
        R.drawable.uruguaybayrak,
        "İzlanda",
        "Arjantin",
        "Uruguay",
        "Yeni Zelanda",
        3)

        sorularListesi.add(soru2)

        //3.soru
        val soru3 = Sorular(3,"Aşağıdaki sanatçının ismi nedir",
        R.drawable.haluklevent,
        "Haluk Levent",
        "Cem Karaca",
        "Soner Sarıkabadayı",
        "Bilgin Özçalkan",
        1)

        sorularListesi.add(soru3)

        //4.soru
        val soru4 = Sorular(4, "Namık Kemal Üniversitesi Mühendislik Fakültesi hangi il ve ilçede bulunmaktadır",
        R.drawable.namikk,
        "Tekirdağ-Çorlu",
        "Edirne-Enez",
        "Tekirdağ-Süleymanpaşa",
        "Edirne-Erikli",
        1)

        sorularListesi.add(soru4)

        return sorularListesi

    }

}