package com.example.desafiomarvel.model

import com.example.desafiomarvel.api.ResponseApi
import com.example.desafiomarvel.model.comicbookmodel.Data
import com.example.desafiomarvel.model.comicbookmodel.ModeloMarvel
import com.example.desafiomarvel.model.repository.MarvelApiRepository
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class HomeBusiness {
    private val repository by lazy {
        MarvelApiRepository()
    }

    suspend fun getComicBook(characterID: Int): ResponseApi {
        val response = repository.getComicBook(characterID)
        return if (response is ResponseApi.Sucess) {
            val comicbook = response.data as ModeloMarvel

           //ajustando regras de negocio
            comicbook.data.results.forEach {
                it.issueNumber = "#${it.issueNumber}"
            }
            //Preço
            comicbook?.data.results?.forEach {
                it.prices?.forEach {
                    it.price = "$ ${it.price}"
                }
            }

            //Datas
            comicbook?.data.results?.forEach {
                it.dates?.forEach {
                    var targetFormat = "MM / YYYY "
                    var currentFormat = "yyyy-MM-dd'T'hh:mm:ss"
                    var sourceDate = it.date
                    var timeZone = "UTC"
                    var dataFormat = SimpleDateFormat(currentFormat)
                    dataFormat.timeZone = TimeZone.getTimeZone(timeZone)
                    var destDf = SimpleDateFormat(targetFormat)

                    try {
                        var date = dataFormat.parse(sourceDate)
                        var targetDate = destDf.format(date)
                        it.date =  targetDate

                    }catch (ex : ParseException){
                        ex.printStackTrace()
                    }
                }

                //

            }


            ResponseApi.Sucess(comicbook)
        } else {
            response
        }
    }

}