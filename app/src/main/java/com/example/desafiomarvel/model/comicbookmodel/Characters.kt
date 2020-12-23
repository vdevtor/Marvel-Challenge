package com.example.desafiomarvel.model.comicbookmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Characters(
    val available: String,
    val collectionURI: String,
    val returned: String
):Parcelable