package com.example.desafiomarvel.model.comicbookmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    var price: String,
    val type: String
):Parcelable