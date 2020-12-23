package com.example.desafiomarvel.model.comicbookmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CollectedIssue(
    val name: String,
    val resourceURI: String
): Parcelable