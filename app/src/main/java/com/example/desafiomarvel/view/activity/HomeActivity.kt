package com.example.desafiomarvel.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiomarvel.databinding.ActivityHomeBinding

import com.example.desafiomarvel.utils.Constants.Companion.KEY_INTENT_COMIC

import com.example.desafiomarvel.utils.Constants.Companion.hero
import com.example.desafiomarvel.utils.Constants.Companion.isClosed
import com.example.desafiomarvel.view.adapter.HomeAdapter
import com.example.desafiomarvel.viewmodel.HomeViewModel


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "MARVEL"
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        if (hero == "Spider") {
            setUpRecycle(1009610)
        }else if (hero == "Thor"){
            setUpRecycle(1009664)
        }else if (hero == "Captain"){
            setUpRecycle(1009220)
        }
        binding.ivSpiderButton.setOnClickListener {
            hero = "Spider"
            setUpRecycle(1009610)
        }
        binding.ivThorButton.setOnClickListener {
            hero = "Thor"
            setUpRecycle(1009664)
        }
        binding.ivCaptainButton.setOnClickListener {
            hero = "Captain"
            setUpRecycle(1009220)
        }

    }

    fun setUpRecycle(characterId: Int){
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getComicBook(characterId)
        viewModel.onResultComicBook.observe(this, {
            it?.let {
                binding.recycleView.apply {
                    layoutManager = GridLayoutManager(this@HomeActivity, 3)
                    adapter = HomeAdapter(it.data.results,) {position ->
                        val intent =  Intent(this@HomeActivity,DescriptionActivity::class.java)
                        intent.putExtra(KEY_INTENT_COMIC,it.data.results[position])
                        isClosed = true
                        startActivity(intent)
                        Toast.makeText(this@HomeActivity,"cliquei",Toast.LENGTH_SHORT).show()

                    }

                }

            }

        })

    }

}






