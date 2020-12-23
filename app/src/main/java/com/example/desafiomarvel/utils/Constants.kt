package com.example.desafiomarvel.utils

import androidx.fragment.app.FragmentManager
import kotlin.properties.Delegates

class Constants {

    companion object{
        var isokay = false
        var isokay2 = false
        var hero = "Spider"
        const val KEY_INTENT_COMIC = "comicBook"
        lateinit var fm : FragmentManager
        var isClosed = true

    }

    object Api{
        const val  BASE_URL = "http://gateway.marvel.com/"
        const val PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"
        const val PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0"
        const val IMAGE_VARIANT = "portrait_medium"



    }
}