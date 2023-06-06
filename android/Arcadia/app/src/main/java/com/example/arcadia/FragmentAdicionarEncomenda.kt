package com.example.arcadia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.arcadia.api.Apis
import com.example.arcadia.databinding.FragmentAdicionarEncomendaBinding
import com.example.arcadia.interfaces.ApiUsuarios
import com.example.arcadia.models.Encomenda
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FragmentAdicionarEncomenda() : Fragment() {

    private lateinit var binding: FragmentAdicionarEncomendaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdicionarEncomendaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdicionarEncomenda.setOnClickListener {
            cadastrarEncomenda()
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    fun cadastrarEncomenda() {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Apis.BASE_URL)
            .build()
            .create(ApiUsuarios::class.java)

        val etCodRastreio = view?.findViewById<EditText>(R.id.input_codigo_rastreio)
        val etDesc = view?.findViewById<EditText>(R.id.input_descricao_compra)

        val codRastreio = etCodRastreio?.text.toString()
        val desc = etDesc?.text.toString()

        val retrofitData = retrofitBuilder.postCadastrarEncomenda(codRastreio, desc)

        retrofitData.enqueue(object : Callback<Encomenda> {
            override fun onResponse(
                call: Call<Encomenda>,
                response: Response<Encomenda>
            ) {
                Toast.makeText(view?.context, "Encomenda Cadastrada com Sucesso!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Encomenda>, t: Throwable) {
                Toast.makeText(view?.context, "Encomenda Cadastrada com Sucesso!", Toast.LENGTH_SHORT).show()
            }
        })
    }

}