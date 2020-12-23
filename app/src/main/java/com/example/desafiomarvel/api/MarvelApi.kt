package com.example.desafiomarvel.api

import com.example.desafiomarvel.model.comicbookmodel.Data
import com.example.desafiomarvel.model.comicbookmodel.ModeloMarvel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface MarvelApi {

    @GET("v1/public/characters/{characterId}/comics")
    suspend fun getComicBoook(
            @Path("characterId") characterID : Int
    ) : Response<ModeloMarvel>
}