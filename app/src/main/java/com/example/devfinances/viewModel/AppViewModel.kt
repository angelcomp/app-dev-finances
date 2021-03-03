package com.example.devfinances.viewModel

import androidx.lifecycle.ViewModel
import com.example.devfinances.ListaSingleton
import com.example.devfinances.domain.Gasto
import java.text.FieldPosition

class AppViewModel(): ViewModel() {

    var listinha: MutableList<Gasto> = mutableListOf()

    fun atualizarLista() {
        listinha = ListaSingleton.lista
        somaGastos()
    }

    fun add(gasto: Gasto) {
        ListaSingleton.lista.add(gasto)
        atualizarLista()
    }

    fun remove(position: Int) {
        var gasto = ListaSingleton.lista[position]
        ListaSingleton.lista.remove(gasto)
        atualizarLista()
    }

    fun somaGastos() {
        ListaSingleton.total = 0.0
        ListaSingleton.positivo = 0.0
        ListaSingleton.negativo = 0.0

        ListaSingleton.lista.forEach {
            if (it.ganhou) {
                ListaSingleton.positivo += it.valor
            } else {
                ListaSingleton.negativo -= it.valor
                println("valor: ${ListaSingleton.negativo}")
            }
        }
        ListaSingleton.total = ListaSingleton.positivo + ListaSingleton.negativo
    }
}