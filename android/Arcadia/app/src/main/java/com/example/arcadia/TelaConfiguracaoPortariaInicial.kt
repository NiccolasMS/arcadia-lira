package com.example.arcadia

import NavegacaoFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TelaConfiguracaoPortariaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_configuracao_portaria_inicial)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_menu, NavegacaoFragment(), "FRAGMENT_MENU")
        transaction.commit()

    }
}
