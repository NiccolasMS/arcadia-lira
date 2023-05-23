package com.example.arcadia

import NavegacaoFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        //val transaction = supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.fragment_tela_principal, HomeFragment(), "FRAGMENT_TELA")
        //transaction.replace(R.id.fragment_menu_principal, NavegacaoFragment(), "FRAGMENT_HOME")
        //transaction.commit()
    }
}