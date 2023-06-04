package com.example.arcadia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.R
import com.example.arcadia.models.Encomenda

class MyAdapter(val context: Context, val listaEncomenda: List<Encomenda>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var codigoDeRastreio: TextView
        var descricao: TextView

        init {
            codigoDeRastreio = itemView.codigoDeRastreio
            descricao = itemView.descricao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(context).inflate(R.layout.row_notification_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaEncomenda.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.codigoDeRastreio.text = listaEncomenda[position].codigoDeRastreio
        holder.descricao.text = listaEncomenda[position].descricao
    }
}