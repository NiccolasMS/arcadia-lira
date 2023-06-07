package com.example.arcadia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.arcadia.R

class TermosDeUso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termos_de_uso)
    }

    fun aceitar(component: View) {
        val telaCadastro =
            Intent(applicationContext, TelaCadastro::class.java)
        startActivity(telaCadastro)
    }

}