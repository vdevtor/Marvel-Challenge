package com.example.desafiomarvel.api

sealed class ResponseApi {
    class Sucess(val data: Any?) : ResponseApi()
    class Error(val message : String) : ResponseApi()
}