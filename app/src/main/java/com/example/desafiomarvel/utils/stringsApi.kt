package com.example.desafiomarvel.utils

import com.example.desafiomarvel.utils.Constants.Companion.hero
import java.security.NoSuchAlgorithmException

fun String.md5():String{

    try {

        val digest = java.security.MessageDigest.getInstance("MD5")
        digest.update(toByteArray())
        val messageDigest = digest.digest()
        val hexString =StringBuilder()
        for (aMessageDigest in messageDigest){
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2)
                h = "0$h"
            hexString.append(h)
        }
        return  hexString.toString()
    } catch (e: NoSuchAlgorithmException){
        e.printStackTrace()
    }
    return ""
}

fun getString():String{
    var currentHero = ""

    if (hero == "Spider"){
        currentHero = "\"Bitten by a radioactive spider, high school student Peter Parker gained the speed, strength and powers of a spider. " +
                "Adopting the name Spider-Man, Peter hoped to start a career using his new abilities. " +
                "Taught that with great power comes great responsibility, Spidey " +
                "has vowed to use his powers to help people.\""
    }else if (hero == "Thor"){
        currentHero ="\"As the Norse God of thunder and lightning, Thor wields one of the greatest weapons ever made, " +
                "the enchanted hammer Mjolnir. While others have described Thor as an over-muscled, oafish imbecile, " +
                "he's quite smart and compassionate.  He's self-assured," +
                " and he would never, ever stop fighting for a worthwhile cause.\""
    }else if (hero == "Captain"){
        currentHero = "\"Vowing to serve his country any way he could, young Steve Rogers took the super soldier serum to become America's " +
                "one-man army. Fighting for the red, white and blue for over 60 years, " +
                "Captain America is the living, breathing symbol of freedom and liberty.\""
    }

    return currentHero
}

