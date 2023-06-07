package com.example.arcadia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.arcadia.R

class TelaConfiguracaoPortaria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_configuracao_portaria)
    }

    fun voltarPortaria(component: View) {
        val telaLogin =
            Intent(applicationContext, TelaLogin::class.java)
        startActivity(telaLogin)
    }

    fun salvarPortaria(component: View) {
        val telaLogin =
            Intent(applicationContext, TelaLogin::class.java)
        startActivity(telaLogin)
    }
}