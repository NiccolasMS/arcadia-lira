package com.example.arcadia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.adapter.MyAdapter
import com.example.arcadia.api.Apis
import com.example.arcadia.interfaces.ApiUsuarios
import com.example.arcadia.models.Encomenda
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EncomendaFragment : Fragment() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    private val listaEncomendas = mutableListOf<Encomenda>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encomenda, container, false)
    }

    private fun telaEditar(encomenda: Encomenda) {

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction!!.replace(R.id.fragment_tela_principal, FragmentEditarEncomenda(encomenda), "FRAGMENT_EDITAR_ENCOMENDA")
        transaction.commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAdapter = MyAdapter(listaEncomendas) {
            val encomenda = it
            telaEditar(encomenda)
        }

        linearLayoutManager = LinearLayoutManager(view.context)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_notificacoes)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = myAdapter

        getEncomendas()
    }


    private fun getEncomendas() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Apis.BASE_URL)
            .build()
            .create(ApiUsuarios::class.java)


        val retrofitData = retrofitBuilder.getEncomendas()


        retrofitData.enqueue(object : Callback<List<Encomenda>?> {
            override fun onResponse(
                call: Call<List<Encomenda>?>,
                response: Response<List<Encomenda>?>
            ) {
                val responseBody = response.body()!!

                listaEncomendas.addAll(responseBody)
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Encomenda>?>, t: Throwable) {
                Log.d("TelaPrincipal", "onFailure: " + t.message)
            }
        })
    }
}