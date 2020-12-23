package com.example.desafiomarvel.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.desafiomarvel.databinding.ActivityDescriptionBinding
import com.example.desafiomarvel.model.comicbookmodel.Result
import com.example.desafiomarvel.utils.Constants.Companion.KEY_INTENT_COMIC
import com.example.desafiomarvel.utils.Constants.Companion.fm
import com.example.desafiomarvel.utils.Constants.Companion.isClosed
import com.example.desafiomarvel.utils.load
import com.example.desafiomarvel.view.fragment.PosterFragment


class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var comicBook = intent.getParcelableExtra<Result>(KEY_INTENT_COMIC)
        binding.tvSinopseComicBook.text = comicBook?.description ?: com.example.desafiomarvel.utils.getString()
        binding.tvPagesGet.text = comicBook?.pageCount
        binding.tvTitleComicBook.text = comicBook?.title ?: "Comic book has no title"


        //gerando bundle

        var bundle = Bundle()
        bundle.putParcelable("passa",comicBook)
        var posterFragment = PosterFragment()
        posterFragment.arguments = bundle
        

       //configurando os Dados Recebidos

        comicBook?.prices?.forEach {
            binding.tvPriceGet.text = it.price
        }

        comicBook?.dates?.forEach {
            binding.tvPublishedGet.text = it.date
        }

        comicBook?.images?.last().let{
           Glide.with(this).load("${it?.path}/landscape_amazing.${it?.extension}").into(binding.ivCoverDescription)

        }
        val imgThumbnail = binding.ivPosterDescription
        imgThumbnail.load("${comicBook?.thumbnail?.path}/portrait_fantastic.${comicBook?.thumbnail?.extension}")

        binding.backArrow.setOnClickListener {
            val i = Intent(this,HomeActivity::class.java)
            startActivity(i)
            finish()
        }

        binding.closeBtn.setOnClickListener {
            fm.popBackStack()
            binding.cvDescription.visibility = View.VISIBLE
            binding.ivPosterDescription.visibility = View.VISIBLE
            binding.volta.visibility = View.GONE
            binding.closeBtn.visibility = View.GONE
            isClosed = true


        }

        binding.ivPosterDescription.setOnClickListener {
           fm = supportFragmentManager
            fm.beginTransaction().add(binding.fragmentContainer.id,posterFragment).addToBackStack(null).commit()
            binding.ivPosterDescription.visibility = View.GONE
           binding.cvDescription.visibility = View.GONE
            binding.volta.visibility = View.VISIBLE
            binding.closeBtn.visibility = View.VISIBLE
            isClosed = false

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (isClosed == false) {
            fm.popBackStack()
            binding.cvDescription.visibility = View.VISIBLE
            binding.ivPosterDescription.visibility = View.VISIBLE
            binding.volta.visibility = View.GONE
            binding.closeBtn.visibility = View.GONE
            isClosed = true

        } else {
            isClosed = true
            super.onBackPressed()
        }
    }

}