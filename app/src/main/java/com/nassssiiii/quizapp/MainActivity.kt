package com.nassssiiii.quizapp

//import android.R
import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nassssiiii.quizapp.databinding.ActivityMainBinding


 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.butonStart.setOnClickListener {
            if(binding.editTextTextPersonName.text.toString().isEmpty()){
                Toast.makeText(this,"İsim boş bırakılamaz",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizzQuestionActivity::class.java)
                intent.putExtra(Sabitler.KULLANICI_ADI, binding.editTextTextPersonName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}