package com.example.desafiomarvel.model.comicbookmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
        val characters: Characters,
        val collectedIssues: List<CollectedIssue>,
        val dates: Array<Date>?,
        val description: String?,
        val diamondCode: String,
        val digitalId: String,
        val ean: String,
        val format: String,
        val id: String,
        val images: List<Image>?,
        val isbn: String,
        val issn: String,
        var issueNumber: String?,
        val modified: String,
        val pageCount: String,
        val prices: Array<Price>?,
        val resourceURI: String,
        val textObjects: List<TextObject>,
        val thumbnail: Thumbnail?,
        val title: String,
        val upc: String,
        val variantDescription: String,

        ):Parcelable