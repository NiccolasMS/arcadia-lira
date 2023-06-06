package com.example.arcadia

import MyAdapterNoticia
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.adapter.MyAdapter
import com.example.arcadia.api.Apis
import com.example.arcadia.interfaces.ApiUsuarios
import com.example.arcadia.models.Encomenda
import com.example.arcadia.models.Noticia
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    lateinit var myAdapter: MyAdapterNoticia
    lateinit var linearLayoutManager: LinearLayoutManager
    private val listaNoticia = mutableListOf<Noticia>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun telaEditarNoticia(noticia: Noticia) {

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction!!.replace(R.id.fragment_tela_principal, FragmentEditarNoticia(noticia), "FRAGMENT_EDITAR_NOTICIA")
        transaction.commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAdapter = MyAdapterNoticia(listaNoticia) {
            val noticia = it
            telaEditarNoticia(noticia)
        }

        linearLayoutManager = LinearLayoutManager(view.context)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_noticias)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = myAdapter

        getNoticias()
    }


    private fun getNoticias() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Apis.BASE_URL)
            .build()
            .create(ApiUsuarios::class.java)


        val retrofitData = retrofitBuilder.getNoticias()


        retrofitData.enqueue(object : Callback<List<Noticia>?> {
            override fun onResponse(
                call: Call<List<Noticia>?>,
                response: Response<List<Noticia>?>
            ) {
                val responseBody = response.body()!!

                listaNoticia.addAll(responseBody)
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Noticia>?>, t: Throwable) {
                Log.d("TelaHome", "onFailure: " + t.message)
            }
        })
    }

}