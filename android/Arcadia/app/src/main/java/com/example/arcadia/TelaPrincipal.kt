package com.example.arcadia

import NavegacaoFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcadia.adapter.MyAdapter
import com.example.arcadia.api.Apis
import com.example.arcadia.interfaces.ApiUsuarios
import com.example.arcadia.models.Encomenda
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        //transaction.replace(R.id.fragment_menu_principal, NavegacaoFragment(), "FRAGMENT_HOME")
        //transaction.commit()

    }
}