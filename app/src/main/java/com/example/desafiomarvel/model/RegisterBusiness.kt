package com.example.desafiomarvel.model

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.desafiomarvel.utils.Constants

class RegisterBusiness {

    fun validaEmail(editEmail: EditText?, btn : Button?, editName: EditText?,editSenha : EditText?) : Boolean {
        editEmail?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(editEmail?.text.toString()).matches())
                    Constants.isokay2 = true
                else {
                    //  btn?.isEnabled = false
                    Constants.isokay2 = false
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(editEmail?.text.toString()).matches())
                    Constants.isokay2 = true
                else {
                    Constants.isokay2 = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(editEmail?.text.toString()).matches())
                    Constants.isokay2 = true
                else {
                    Constants.isokay2 = false
                }
            }
        })

        if (editName != null){
            if (editName.text.isBlank()){
                editName.error = "Type your full name"
                Constants.isokay2 = false

            }
        }

        if (editSenha != null){
            if (editSenha.text.isBlank()){
                editSenha.error = "Type your password"
                Constants.isokay2 = false
            }
        }

        if (editEmail != null){
            if (editEmail.text.isBlank()){
                editEmail.error = "Type your email"
                Constants.isokay2 = false
            }
        }

            return Constants.isokay2
    }


    fun validate(edtEmail: EditText?,btnLogin: Button?,edtTextSenha : EditText,editName:EditText,context: Context?): Boolean {
        var isokay2 = validaEmail(edtEmail, btnLogin, edtTextSenha,editName)
        if (edtEmail != null) {
            if (isokay2 && edtEmail?.text.isNotBlank() && edtTextSenha.text.isNotBlank() && editName.text.isNotBlank()) {

                btnLogin?.error = null
                validaEmail(edtEmail, btnLogin, edtTextSenha,editName)

            } else if (isokay2 || edtEmail.text.isNotBlank() && edtTextSenha.text.isBlank() || editName.text.isBlank()) {
                Toast.makeText(context, "there are some empty fields", Toast.LENGTH_SHORT).show()
                validaEmail(edtEmail, btnLogin, edtTextSenha,editName)
            } else if (!isokay2 || edtEmail.text.isBlank() && edtTextSenha.text.isNotBlank() && editName.text.isNotBlank()) {
                Toast.makeText(context, "invalid email", Toast.LENGTH_SHORT).show()
                validaEmail(edtEmail, btnLogin, edtTextSenha,editName)
            }
            validaEmail(edtEmail, btnLogin, edtTextSenha,editName)


        }
        return isokay2
    }
}