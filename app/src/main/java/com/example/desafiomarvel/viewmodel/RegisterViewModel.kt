package com.example.desafiomarvel.viewmodel

import android.content.Context
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.example.desafiomarvel.model.RegisterBusiness

class RegisterViewModel: ViewModel() {
    private val registerBusiness by lazy {
        RegisterBusiness()
    }

    fun validateEmail(editEmail : EditText,button: Button,editSenha : EditText,editName : EditText){
        registerBusiness.validaEmail(editEmail,button,editSenha,editName)
    }

    fun validate(editEmail: EditText,button: Button,editSenha: EditText,editName: EditText,context: Context): Boolean{
        return registerBusiness.validate(editEmail,button,editSenha,editName,context)
    }

}