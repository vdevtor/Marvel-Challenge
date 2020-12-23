package com.example.desafiomarvel.model.comicbookmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TextObject(
    val language: String,
    val text: String,
    val type: String
):Parcelable