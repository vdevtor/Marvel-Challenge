package com.example.desafiomarvel.view.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.desafiomarvel.databinding.ActivityTelaLoginBinding
import com.example.desafiomarvel.viewmodel.TelaLoginViewModel

class TelaLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaLoginBinding
    private lateinit var viewModel : TelaLoginViewModel
    private lateinit var edtText : EditText
    private lateinit var btnLogin : Button
    private lateinit var edtTextSenha : EditText
    private var sharedPreferences : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        edtText = binding.etEmailLogin
        edtTextSenha = binding.etSenhaLogin
        btnLogin = binding.btnLogin

        //UsandoSharedPreferences
        sharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE)
        val email = sharedPreferences?.getString("email", "")
        val senha = sharedPreferences?.getString("senha", "")
        edtText.setText(email)
        edtTextSenha.setText(senha)

        viewModel = ViewModelProvider(this).get(TelaLoginViewModel::class.java)

        viewModel.validaEmail(edtText,btnLogin,edtTextSenha)


            binding.btnLogin.setOnClickListener {
                    viewModel.validate(edtText, btnLogin, edtTextSenha,this,email,senha)
                var ck =viewModel.validate(edtText, btnLogin, edtTextSenha,this,email,senha)
                     if (ck){
                    val i = Intent(this, HomeActivity::class.java)
                    startActivity(i)
                         finish()
                }
            }
            binding.btnCreatateAccount.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }





}