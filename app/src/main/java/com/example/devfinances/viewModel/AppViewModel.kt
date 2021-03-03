package com.example.devfinances.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.devfinances.ListaSingleton
import com.example.devfinances.domain.Gasto

class AppViewModel(): ViewModel() {

    var listinha: MutableList<Gasto> = mutableListOf()

    fun atualizarLista() {
        listinha = ListaSingleton.lista
        somaGastos()
    }

    fun add(gasto: Gasto) {
        ListaSingleton.lista.add(gasto)
        somaGastos()
    }

    fun remove(gasto: Gasto) {
        listinha.remove(gasto)
        somaGastos()

    }

    fun somaGastos() {
        listinha.forEach {
            if (it.ganhou) {
                ListaSingleton.positivo += it.valor
            } else {
                ListaSingleton.negativo -= it.valor
            }
        }
        ListaSingleton.total = ListaSingleton.positivo + ListaSingleton.negativo
    }
}