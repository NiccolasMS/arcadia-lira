package com.example.arcadia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.arcadia.R

class TelaConfiguracaoCondomino : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_configuracao_condomino)
    }

    fun voltarCondomino(component: View) {
        finish()
    }

    fun salvarCondomino(component: View) {
        finish()
    }
}