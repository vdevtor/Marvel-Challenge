package com.example.desafiomarvel.viewmodel

import android.content.Context
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.example.desafiomarvel.model.TelaLoginBusiness

class TelaLoginViewModel: ViewModel() {
    private val telaLoginBusiness by lazy{
        TelaLoginBusiness()
    }

    fun validaEmail(editText: EditText?,button: Button?,editText2: EditText?): Boolean{
        return telaLoginBusiness.validaEmail(editText,button,editText2)
    }
    fun validate(edtText: EditText,btnLogin : Button,edtTextSenha : EditText,context: Context, email: String?,senha:String?): Boolean{
        return telaLoginBusiness.validate(edtText,btnLogin,edtTextSenha,context,email,senha)
    }
}