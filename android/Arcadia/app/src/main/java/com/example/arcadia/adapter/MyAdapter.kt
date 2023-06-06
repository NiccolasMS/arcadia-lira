package com.example.arcadia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.R
import com.example.arcadia.models.Encomenda

class MyAdapter(val listaEncomenda: List<Encomenda>, val onClick: (Encomenda) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var codigoDeRastreio = itemView.findViewById<TextView>(R.id.codigoDeRastreio)
        var descricao = itemView.findViewById<TextView>(R.id.descricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_encomenda_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaEncomenda.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val encomenda = listaEncomenda[position]

        holder.codigoDeRastreio.text = encomenda.codigoDeRastreio
        holder.descricao.text = encomenda.descricao

        holder.itemView.setOnClickListener {
            onClick(encomenda)
        }
    }
}