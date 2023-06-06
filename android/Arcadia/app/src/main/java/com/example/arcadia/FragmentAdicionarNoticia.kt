package com.example.arcadia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.arcadia.api.Apis
import com.example.arcadia.databinding.FragmentAdicionarEncomendaBinding
import com.example.arcadia.databinding.FragmentAdicionarNoticiaBinding
import com.example.arcadia.interfaces.ApiUsuarios
import com.example.arcadia.models.Encomenda
import com.example.arcadia.models.Noticia
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FragmentAdicionarNoticia : Fragment() {

    private lateinit var binding: FragmentAdicionarNoticiaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdicionarNoticiaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdicionarNoticia.setOnClickListener {
            adicionarNoticia()
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    fun adicionarNoticia() {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Apis.BASE_URL)
            .build()
            .create(ApiUsuarios::class.java)

        val etNoticia = view?.findViewById<EditText>(R.id.input_titulo_noticia)
        val etDesc = view?.findViewById<EditText>(R.id.input_descricao_noticia)

        val titulo = etNoticia?.text.toString()
        val descricao = etDesc?.text.toString()

        val retrofitData = retrofitBuilder.postAdicionarNoticia(titulo, descricao)

        retrofitData.enqueue(object : Callback<Noticia> {
            override fun onResponse(
                call: Call<Noticia>,
                response: Response<Noticia>
            ) {
                Toast.makeText(view?.context, "Notícia Adicionada ao Feed!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Noticia>, t: Throwable) {
                Toast.makeText(view?.context, "Notícia Adicionada ao Feed!", Toast.LENGTH_SHORT).show()
            }
        })
    }

}