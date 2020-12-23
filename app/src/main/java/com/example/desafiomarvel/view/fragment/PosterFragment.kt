package com.example.desafiomarvel.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafiomarvel.databinding.ActivityDescriptionBinding

import com.example.desafiomarvel.databinding.FragmentPosterBinding
import com.example.desafiomarvel.model.comicbookmodel.Result
import com.example.desafiomarvel.utils.Constants.Companion.fm
import com.example.desafiomarvel.utils.Constants.Companion.isClosed
import com.example.desafiomarvel.utils.load
import com.example.desafiomarvel.view.activity.DescriptionActivity


class PosterFragment : Fragment() {
    private var binding: FragmentPosterBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPosterBinding.inflate(layoutInflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var comicbook = arguments?.getParcelable<Result>("passa")
        activity

        val imgThumbnail = binding?.ivPosterPoster
        imgThumbnail?.load("${comicbook?.thumbnail?.path}/portrait_uncanny.${comicbook?.thumbnail?.extension}")





    }


}