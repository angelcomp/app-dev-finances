package com.example.devfinances.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.devfinances.domain.Gasto
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
            var card = findViewById<CardView>(R.id.card)

            descricao.text = gasto.descricao
            data.text = gasto.data

            if (gasto.ganhou) {
                valor.text = "${gasto.valor}0"
                valor.setTextColor(getResources().getColor(R.color.green))
                card.setBackgroundColor(getResources().getColor(R.color.ganhei))
            } else {
                valor.text = "-${gasto.valor}0"
                valor.setTextColor(getResources().getColor(R.color.red))
                card.setCardBackgroundColor(getResources().getColor(R.color.gastei))
            }
        }
    }
}