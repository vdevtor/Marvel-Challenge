package com.example.desafiomarvel.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiomarvel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivSplashScreen.animate().alpha(1f).setDuration(1100).withEndAction(){
            val i = Intent(this, TelaLoginActivity::class.java)
            startActivity(i)
            finish()
        }










    }
}