package com.nassssiiii.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nassssiiii.quizapp.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kullaniciadi = intent.getStringExtra(Sabitler.KULLANICI_ADI)
        binding.kullaniciadiText.text = kullaniciadi

        val toplamdogru = intent.getStringExtra(Sabitler.DOGRU_CEVAPLAR)
        binding.toplamDogruSayisi.text = "$toplamdogru" + " " + "tanesini doğru cevapladınız"

        val toplamsoru = intent.getStringExtra(Sabitler.TOPLAM_SORU_SAYISI)
        binding.toplamSoruSayisi.text = "$toplamsoru" + " " + "sorudan "

        binding.buttonCikis.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}