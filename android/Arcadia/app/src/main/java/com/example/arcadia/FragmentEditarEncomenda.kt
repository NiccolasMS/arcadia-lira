package com.example.arcadia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.arcadia.api.Apis
import com.example.arcadia.databinding.FragmentEditarEncomendaBinding
import com.example.arcadia.interfaces.ApiUsuarios
import com.example.arcadia.models.Encomenda
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FragmentEditarEncomenda(
    val encomenda: Encomenda
) : Fragment() {

    private lateinit var binding: FragmentEditarEncomendaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEditarEncomendaBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inputCodigoRastreio.setText(encomenda.codigoDeRastreio)
        binding.inputDescricaoCompra.setText(encomenda.descricao)


        binding.btnExcluir.setOnClickListener {
            excluir()
        }
    }

    private fun excluir() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Apis.BASE_URL)
            .build()
            .create(ApiUsuarios::class.java)


        val retrofitData = retrofitBuilder.deleteEncomenda(encomenda.id)


        retrofitData.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful){
                    Toast.makeText(view?.context, "DELETADO COM SUCESSO", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("TelaPrincipal", "onFailure: " + t.message)
            }
        })
    }
}