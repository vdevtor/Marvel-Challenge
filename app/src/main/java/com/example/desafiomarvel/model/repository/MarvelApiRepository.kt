package com.example.desafiomarvel.model.repository

import com.example.desafiomarvel.api.ApiService
import com.example.desafiomarvel.api.ResponseApi

class MarvelApiRepository {
    suspend fun getComicBook(characterID : Int): ResponseApi{
        return try {
            val response = ApiService.marvelApi.getComicBoook(characterID)
            if (response.isSuccessful){
                ResponseApi.Sucess(response.body())
            }else{
                if (response.code() == 404){
                    ResponseApi.Error("Dado não Encontrado")
                }else{
                    ResponseApi.Error("Erro ao carregar os Dados")
                }

            }
        }catch (exception : Exception){
            ResponseApi.Error("Erro ao carregar os Dados")
        }
    }
}