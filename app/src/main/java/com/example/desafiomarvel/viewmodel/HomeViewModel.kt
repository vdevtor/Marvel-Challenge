package com.example.desafiomarvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiomarvel.api.ResponseApi
import com.example.desafiomarvel.model.HomeBusiness
import com.example.desafiomarvel.model.comicbookmodel.Data
import com.example.desafiomarvel.model.comicbookmodel.ModeloMarvel
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val onResultComicBook: MutableLiveData<ModeloMarvel> = MutableLiveData()
    val onResultFailure : MutableLiveData<String> = MutableLiveData()
    private val business by lazy{
        HomeBusiness()
    }
    fun getComicBook(characterId:Int){
        viewModelScope.launch {
            when(val response = business.getComicBook(characterId)){
                is ResponseApi.Sucess ->{
                    onResultComicBook.postValue(response.data as ModeloMarvel)

                }
                is ResponseApi.Error ->{
                    onResultFailure.postValue((response.message))
                }
            }
        }
    }
}