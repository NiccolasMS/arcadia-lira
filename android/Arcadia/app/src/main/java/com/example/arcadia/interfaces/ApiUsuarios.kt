package com.example.arcadia.interfaces

import android.widget.EditText
import com.example.arcadia.models.Morador
import com.example.arcadia.models.Porteiro
import com.example.arcadia.models.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiUsuarios {

    @POST("usuarios/cadastrarMorador")
    fun postCadastrarMorador(@Body morador: Morador) : Call<List<Morador>>

    @POST("usuarios/cadastrarPorteiro")
    fun postCadastrarPorteiro(@Body porteiro: Porteiro) : Call<List<Porteiro>>

    @POST("usuarios/loginMorador/{email}/{senha}")
    fun postLoginMorador(@Path("email") email:String, @Path("senha") senha:String) : Call<List<Morador>>

    @POST("usuarios/loginPorteiro/{email}/{senha}")
    fun postLoginPorteiro(@Path("email") email:String, @Path("senha") senha:String) : Call<List<Porteiro>>

}