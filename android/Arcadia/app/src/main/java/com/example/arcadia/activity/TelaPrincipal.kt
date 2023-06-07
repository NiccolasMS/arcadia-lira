package com.example.arcadia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcadia.R

class TelaPrincipal : AppCompatActivity() {

    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

//        recyclerview_notificacoes.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
//        recyclerview_notificacoes.layoutManager = linearLayoutManager
        //val transaction = supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.fragment_tela_principal, HomeFragment(), "FRAGMENT_TELA")
        //transaction.replace(R.id.fragment_menu_principal, com.example.arcadia.Fragments.NavegacaoFragment(), "FRAGMENT_HOME")
        //transaction.commit()

    }
}
