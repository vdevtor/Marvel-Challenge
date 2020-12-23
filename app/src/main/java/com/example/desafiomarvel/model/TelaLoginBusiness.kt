package com.example.desafiomarvel.model



import android.content.Context

import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.desafiomarvel.utils.Constants.Companion.isokay



class TelaLoginBusiness {

    fun validaEmail(editText: EditText?, btn: Button?, editText2: EditText?): Boolean {

        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (android.util.Patterns.EMAIL_ADDRESS.matcher(editText?.text.toString())
                        .matches()
                )
                    isokay = true
                else {
                    //  btn?.isEnabled = false
                    isokay = false
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(editText?.text.toString())
                        .matches()
                )
                    isokay = true
                else {
                    isokay = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(editText?.text.toString())
                        .matches()
                )
                    isokay = true
                else {
                    isokay = false
                }
            }
        })

        if (editText2 != null) {
            if (editText2?.text.isBlank()) {
                editText2?.error = "type your password"
                isokay=false
            }else if(editText2.text.toString().isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(editText?.text.toString())
                    .matches()){
                isokay = true
            }
        }
        return isokay
    }


    fun validate(
        edtText: EditText?,
        btnLogin: Button?,
        edtTextSenha: EditText,
        context: Context?,
        email: String?,
        senha: String?
    ): Boolean {
        isokay = validaEmail(edtText, btnLogin, edtTextSenha)

        if (edtText != null) {
            if (edtText.text.toString() == email && edtTextSenha.text.toString() == senha) {
                isokay = true

                validaEmail(edtText, btnLogin, edtTextSenha)
            } else if (isokay && edtText?.text.isNotBlank() && edtTextSenha.text.isNotBlank()) {
                btnLogin?.error = null

            } else if (isokay || edtText.text.isNotBlank() && edtTextSenha.text.isBlank()) {
                Toast.makeText(context, "password field is empty", Toast.LENGTH_SHORT).show()

            } else if (!isokay || edtText.text.isBlank() && edtTextSenha.text.isNotBlank()) {
                Toast.makeText(context, "email invalido", Toast.LENGTH_SHORT).show()

            }


        }
        return isokay
    }




}