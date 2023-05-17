package com.example.arcadia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.arcadia.api.Apis
import com.example.arcadia.models.Morador
import com.example.arcadia.models.Porteiro
import com.example.arcadia.models.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)
    }

    private fun isEmailValid(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun isSenhaValid(senha: String): Boolean {

        if (senha.length < 6) {
            return false
        } else if (!senha.matches(".*[A-Z].*".toRegex())) {
            Toast.makeText(
                baseContext,
                "Deve conter pelo menos 1 letra maiúscula!",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (!senha.matches(".*[a-z].*".toRegex())) {
            Toast.makeText(
                baseContext,
                "Deve conter pelo menos 1 letra minúscula!",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (!senha.matches(".*[@#\$^&+=].*".toRegex())) {
            Toast.makeText(
                baseContext,
                "Deve conter pelo menos 1 caractere especial (@#\$^&+=)",
                Toast.LENGTH_LONG
            ).show()
            return false
        }

        return true
    }

    fun telaLogin(componente: View) {
        val telaLogin =
            Intent(applicationContext, TelaLogin::class.java)
        startActivity(telaLogin)
    }

    fun cadastrar(componente: View) {

        val etNome = findViewById<EditText>(R.id.input_usuario)
        val etEmail = findViewById<EditText>(R.id.input_email)
        val etSenha = findViewById<EditText>(R.id.input_senha)

        val nome = etNome.text.toString()
        val email = etEmail.text.toString()
        val senha = etSenha.text.toString()

        val apiUsuarios = Apis.getApiUsuarios()




        if (email == "condominio.alpha@hotmail.com" && senha == "Alpha@123") {
            val telaLogin =
                Intent(applicationContext, TelaLogin::class.java)

            var valido = true

            if (nome.isBlank()) {
                valido = false
                etNome.error = "O nome é obrigatório"
            } else if (etNome.text.length < 4) {
                valido = false
                etNome.error = "O nome deve ter pelo menos 4 letras"
            }

            if (!isEmailValid(email)) {
                etEmail.error = "E-mail inválido"
            }

            if (!isSenhaValid(senha)) {
                etSenha.error = "A senha informada não é forte o suficiente!"
            }

            if (valido) {
                val chamadaCadastroPorteiro =
                    apiUsuarios.postCadastrarPorteiro(Porteiro(email, senha, nome))
                chamadaCadastroPorteiro.enqueue(object : Callback<List<Porteiro>> {
                    override fun onResponse(
                        call: Call<List<Porteiro>>,
                        response: Response<List<Porteiro>>
                    ) {
                        if (response.isSuccessful) { // status 2xx (200, 201, 204 etc)
                            if (valido) {
                                startActivity(telaLogin)
                                Toast.makeText(
                                    baseContext,
                                    "Cadastro efetuado com sucesso!",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                Toast.makeText(
                                    baseContext,
                                    "Preencha os campos corretamente e tente novamente!",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                baseContext,
                                "Cadastro efetuado com sucesso!",
                                Toast.LENGTH_LONG
                            ).show()
                            startActivity(telaLogin)
                        }
                    }

                    override fun onFailure(call: Call<List<Porteiro>>, t: Throwable) {
                        Toast.makeText(
                            baseContext, "Erro na API: ${t.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        t.printStackTrace()
                    }
                })
            }
        }

        if (email != "condominio.alpha@hotmail.com" && senha != "Alpha@123") {
            val telaLogin =
                Intent(applicationContext, TelaLogin::class.java)

            var valido = true

            if (nome.isBlank()) {
                valido = false
                etNome.error = "O nome é obrigatório"
            } else if (etNome.text.length < 4) {
                valido = false
                etNome.error = "O nome deve ter pelo menos 4 letras"
            }

            if (!isEmailValid(email)) {
                etEmail.error = "E-mail inválido"
            }

            if (!isSenhaValid(senha)) {
                etSenha.error = "A senha informada não é forte o suficiente!"
            }

            if (valido) {
                val chamadaCadastroMorador =
                    apiUsuarios.postCadastrarMorador(Morador(email, senha, nome))
                chamadaCadastroMorador.enqueue(object : Callback<List<Morador>> {
                    override fun onResponse(
                        call: Call<List<Morador>>,
                        response: Response<List<Morador>>
                    ) {
                        if (response.isSuccessful) { // status 2xx (200, 201, 204 etc)
                            if (valido) {
                                Toast.makeText(
                                    baseContext,
                                    "Cadastro efetuado com sucesso!",
                                    Toast.LENGTH_LONG
                                ).show()
                                startActivity(telaLogin)
                            } else {
                                Toast.makeText(
                                    baseContext,
                                    "Preencha os campos corretamente e tente novamente!",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                baseContext,
                                "Cadastro efetuado com sucesso!",
                                Toast.LENGTH_LONG
                            ).show()
                            startActivity(telaLogin)
                        }
                    }

                    override fun onFailure(call: Call<List<Morador>>, t: Throwable) {
                        Toast.makeText(
                            baseContext, "Erro na API: ${t.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        t.printStackTrace()
                    }
                })
            }
        }
    }

}