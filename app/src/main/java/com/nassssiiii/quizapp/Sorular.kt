package com.nassssiiii.quizapp

data class Sorular (
    val id : Int,
    val soru : String,
    val resim : Int,
    val birinciSecenek : String,
    val IkinciSecenek : String,
    val UcuncuSecenek : String,
    val DorduncuSecenek : String,
    val DogruCevap : Int,
)