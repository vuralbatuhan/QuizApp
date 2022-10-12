package com.nassssiiii.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.nassssiiii.quizapp.databinding.ActivityQuizzQuestionBinding

class QuizzQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var aSuAnkiSira:Int = 1
    private var aSorularList:ArrayList<Sorular>? = null
    private var aSelectedOptionPosition:Int = 0
    private var aDogruCevap: Int = 0
    private var aKullaniciAdi: String? = null

    private lateinit var binding: ActivityQuizzQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizzQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        aKullaniciAdi = intent.getStringExtra(Sabitler.KULLANICI_ADI)
        aSorularList = Sabitler.soruyuCagir()

        setQuestion()

        binding.buttonKaydet.isEnabled = false

        binding.secenekBir.setOnClickListener(this)
        binding.secenekIki.setOnClickListener(this)
        binding.secenekUc.setOnClickListener(this)
        binding.secenekDort.setOnClickListener(this)



    }

    private fun setQuestion(){
        val sorular = aSorularList!![aSuAnkiSira-1]

        defaultOptionsView()

         if(aSuAnkiSira == aSorularList!!.size +1){
            binding.buttonKaydet.text = "BİTİR"
             binding.buttonKaydet.setOnClickListener{
                 val intent = Intent(this,SonucActivity::class.java)
                 startActivity(intent)
                 finish()
             }

        }else{
            binding.buttonKaydet.text = "KAYDET"
        }

        binding.ilerleme.progress = aSuAnkiSira
        binding.ilerlemeText.text = ("$aSuAnkiSira" + "/"+ binding.ilerleme.max)

        binding.soru.text = sorular.soru
        binding.resim.setImageResource(sorular.resim)
        binding.secenekBir.text = sorular.birinciSecenek
        binding.secenekIki.text = sorular.IkinciSecenek
        binding.secenekUc.text = sorular.UcuncuSecenek
        binding.secenekDort.text = sorular.DorduncuSecenek

        binding.buttonKaydet.isEnabled = false
        binding.secenekBir.isClickable = true
        binding.secenekIki.isClickable = true
        binding.secenekUc.isClickable = true
        binding.secenekDort.isClickable = true
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,binding.secenekBir)
        options.add(1,binding.secenekIki)
        options.add(2,binding.secenekUc)
        options.add(3,binding.secenekDort)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A80AA"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.secenekBir ->{
                selectedOptionView(binding.secenekBir, 1)
                binding.buttonKaydet.isEnabled = true
            }
            R.id.secenekIki ->{
                selectedOptionView(binding.secenekIki,2)
                binding.buttonKaydet.isEnabled = true
            }
            R.id.secenekUc ->{
                selectedOptionView(binding.secenekUc, 3)
                binding.buttonKaydet.isEnabled = true
            }
            R.id.secenekDort ->{
                selectedOptionView(binding.secenekDort,4)
                binding.buttonKaydet.isEnabled = true
            }
            R.id.buttonKaydet ->{
                binding.secenekBir.isClickable = false
                binding.secenekIki.isClickable = false
                binding.secenekUc.isClickable = false
                binding.secenekDort.isClickable = false
                if(aSelectedOptionPosition == 0){
                    aSuAnkiSira ++

                    when{
                        aSuAnkiSira <= aSorularList!!.size  ->{
                            setQuestion()
                        }else ->{
                        val intent = Intent(this, SonucActivity::class.java)
                        intent.putExtra(Sabitler.KULLANICI_ADI, aKullaniciAdi)
                        intent.putExtra(Sabitler.DOGRU_CEVAPLAR, aDogruCevap.toString())
                        intent.putExtra(Sabitler.TOPLAM_SORU_SAYISI, aSorularList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                    }
                }else{
                    val sorular = aSorularList?.get(aSuAnkiSira -1)
                    if(sorular!!.DogruCevap != aSelectedOptionPosition){
                        cevapView(aSelectedOptionPosition, R.drawable.yanlis_cevap_arkaplan)

                    }else{
                        aDogruCevap++
                    }
                    cevapView(sorular.DogruCevap, R.drawable.dogru_cevap_arkaplan)

                    if(aSuAnkiSira == aSorularList!!.size){
                        binding.buttonKaydet.text = "BİTİR"
                    }else{
                        binding.buttonKaydet.text = "SONRAKİ SORUYA GEÇ"
                    }
                    aSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun cevapView(cevap:Int, drawableView: Int){
        when(cevap){
            1 ->{
                binding.secenekBir.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
                binding.secenekIki.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 ->{
                binding.secenekUc.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                binding.secenekDort.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        aSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#7A80AA"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_option_border_bg
        )
    }

}