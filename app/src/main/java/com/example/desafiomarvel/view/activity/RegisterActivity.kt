package com.example.desafiomarvel.view.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.desafiomarvel.databinding.ActivityRegisterBinding
import com.example.desafiomarvel.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewmodel : RegisterViewModel
   // variaveis
    private lateinit var editName : EditText
    private lateinit var editSenha : EditText
    private lateinit var button: Button
    private lateinit var editEmail : EditText
    // SharedPreference
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // alimentando variaveis
        editEmail = binding.etEmailRegister
        editName = binding.etNomeRegister
        editSenha = binding.etSenhaRegister
        button = binding.btnSave

        //ativando viewModel

        viewmodel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        viewmodel.validate(editEmail,button,editSenha,editName,this)
        viewmodel.validateEmail(editEmail,button,editSenha,editName)

        //exibindo ação do botão
        binding.btnSave.setOnClickListener {
           var checkRegister = viewmodel.validate(editEmail,button,editSenha,editName,this)

            if (checkRegister){
                val i = Intent(this, HomeActivity::class.java)
                startActivity(i)
                saveData()
                finish()
            }
        }
    }
    fun saveData(){
        sharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor
            ?.putString("email",editEmail.text.toString()?: null)
            ?.putString("senha",editSenha.text.toString()?: null)
            ?.apply()
    }
}