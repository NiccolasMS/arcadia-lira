package com.example.arcadia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaConfiguracaoCondomino : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_configuracao_condomino)
    }

    fun voltarCondomino(component: View) {
        val telaLogin =
            Intent(applicationContext, TelaLogin::class.java)
        startActivity(telaLogin)
    }

    fun salvarCondomino(component: View) {
        val telaLogin =
            Intent(applicationContext, TelaLogin::class.java)
        startActivity(telaLogin)
    }
}