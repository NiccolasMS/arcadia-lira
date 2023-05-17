package com.example.arcadia.api

import com.example.arcadia.interfaces.ApiUsuarios
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
Um object é uma classe a qual será criada apenas
1 instância por todo o projeto
 */

object Apis {
    var BASE_URL = "http://34.233.118.85:8080/"

    // função que cria uma instância de cliente da Api de autenticação
    fun getApiUsuarios() : ApiUsuarios {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuarios::class.java)
    }

}