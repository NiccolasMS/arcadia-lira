package com.example.arcadia.interfaces

import android.widget.EditText
import com.example.arcadia.models.Encomenda
import com.example.arcadia.models.Morador
import com.example.arcadia.models.Porteiro
import com.example.arcadia.models.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
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

    @GET("/encomendas")
    fun getEncomendas() : Call<List<Encomenda>>

    @DELETE("/encomendas/deletarEncomenda/{id}")
    fun deleteEncomenda(@Path("id") id: Int) : Call<Void>

    @PUT("usuarios/logoffMorador/{email}")
    fun putLogoff(@Path("email") email: String?) : Call<Void>

}