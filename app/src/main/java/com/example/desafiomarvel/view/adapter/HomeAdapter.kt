package com.example.desafiomarvel.view.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiomarvel.databinding.ModeloHomeBinding
import com.example.desafiomarvel.model.comicbookmodel.Date
import com.example.desafiomarvel.model.comicbookmodel.Price
import com.example.desafiomarvel.model.comicbookmodel.Result
import com.example.desafiomarvel.utils.load

class HomeAdapter(
        private val comicResultList: List<Result?>?,
        private val onComicBookClicked: (Int) -> Unit
): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ModeloHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgThumbnail = binding.ivComicBook
        val txtNumber = binding.tvComicBook
        fun bind(
            comicBook: Result,
          onComicBookClicked: (Int) -> Unit) = with(binding) {
            binding.tvComicBook.text = comicBook.issueNumber
            binding.ivComicBook.setOnClickListener {
                onComicBookClicked(this@ViewHolder.adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ModeloHomeBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        comicResultList?.get(position)?.let { holder.bind(it,onComicBookClicked) }
        holder.txtNumber.text = comicResultList?.get(position)?.issueNumber
        holder.imgThumbnail.load("${comicResultList?.get(position)?.thumbnail?.path}/portrait_xlarge." +
                "${comicResultList?.get(position)?.thumbnail?.extension}")


    }

    override fun getItemCount(): Int {
        return comicResultList?.size ?: 0
    }
}