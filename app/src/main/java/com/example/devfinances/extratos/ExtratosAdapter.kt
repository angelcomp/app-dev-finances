package com.example.devfinances.extratos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devfinances.Gasto
import com.example.devfinances.R

class ExtratosAdapter(val listaGastos: List<Gasto>) :
    RecyclerView.Adapter<ExtratosAdapter.ExtratosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtratosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gasto_item, parent, false)
        return ExtratosViewHolder(view)
    }

    override fun getItemCount() = listaGastos.size

    override fun onBindViewHolder(holder: ExtratosViewHolder, position: Int) {
        val gasto = listaGastos[position]

        holder.bindView(gasto)
    }

    class ExtratosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(gasto: Gasto) = with(itemView) {
            val descricao = findViewById<TextView>(R.id.tvDescricaoGasto)
            val valor = findViewById<TextView>(R.id.tvValorGasto)
            val data = findViewById<TextView>(R.id.tvDataGasto)

            descricao.text = gasto.descricao
            valor.text = "R$ ${gasto.valor}"
            data.text = gasto.data
        }


    }


}