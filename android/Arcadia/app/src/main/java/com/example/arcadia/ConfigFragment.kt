package com.example.arcadia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.arcadia.api.Apis
import com.example.arcadia.databinding.FragmentConfigBinding
import com.example.arcadia.databinding.FragmentEditarEncomendaBinding
import com.example.arcadia.interfaces.ApiUsuarios
import com.example.arcadia.models.Encomenda
import com.example.arcadia.models.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigFragment : Fragment() {

    private lateinit var binding: FragmentConfigBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfigBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDeslogar.setOnClickListener {
            deslogar()
        }
    }

    private fun deslogar() {

        val telaCadastro =
            Intent(requireActivity().applicationContext, TelaCadastro::class.java)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Apis.BASE_URL)
            .build()
            .create(ApiUsuarios::class.java)

        val retrofitData = retrofitBuilder.putLogoff(SessaoUsuario.email)

        retrofitData.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(view?.context, "LogOff efetuado", Toast.LENGTH_SHORT).show()
                    startActivity(telaCadastro)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("TelaConfig", "onFailure: " + t.message)
            }
        })
    }
}