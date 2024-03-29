package com.example.arcadia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.arcadia.R
import com.example.arcadia.storage.SessaoUsuario
import com.example.arcadia.api.Apis
import com.example.arcadia.models.Morador
import com.example.arcadia.models.Porteiro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
    }

    fun telaCadastro(componente: View) {
        val telaCadastro = Intent(applicationContext, TelaCadastro::class.java)
        startActivity(telaCadastro)
    }

    fun entrar(componente: View) {
        // recuperando os dados enviados pela Activity anterior
        val email = findViewById<EditText>(R.id.input_email).text.toString()
        val senha = findViewById<EditText>(R.id.input_senha).text.toString()

        // instância do cliente da API
        val apiUsuarios = Apis.getApiUsuarios()

        // instância do EndPoint (chamada) que busca p/ login e senha na API
        val chamadaLoginMorador = apiUsuarios.postLoginMorador(email = "email", senha = "senha")
        val chamadaLoginPorteiro = apiUsuarios.postLoginPorteiro(email = "email", senha = "senha")

        // iniciando uma chamada ASSÍNCRONA na API

            val telaPrincipal =
                Intent(applicationContext, TelaPrincipal::class.java)

            chamadaLoginMorador.enqueue(object : Callback<List<Morador>> {
                override fun onResponse(
                    call: Call<List<Morador>>, response: Response<List<Morador>>
                ) {
                    if (response.isSuccessful) { // status 2xx (200, 201, 204 etc)
                        val usuarios = response.body()
                        if (usuarios?.isNotEmpty()!!) {
                            Toast.makeText(
                                baseContext, "Login efetuado com sucesso!", Toast.LENGTH_LONG
                            ).show()
                            SessaoUsuario.email = email
                            startActivity(telaPrincipal)
                        } else {
                            Toast.makeText(
                                baseContext, "Login e/ou senha inválidos!", Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            baseContext, "Login efetuado com sucesso!", Toast.LENGTH_LONG
                        ).show()
                        SessaoUsuario.email = email
                        startActivity(telaPrincipal)
                    }
                }

                override fun onFailure(call: Call<List<Morador>>, t: Throwable) {
                    Toast.makeText(
                        baseContext, "Erro na API: ${t.message}", Toast.LENGTH_SHORT
                    ).show()
                    t.printStackTrace()
                }
            })
        }
}