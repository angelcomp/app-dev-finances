package com.example.devfinances.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.devfinances.domain.Gasto

class AppViewModel(): ViewModel() {

    var listinha = mutableListOf<Gasto>()
    var positivo: Double = 0.0
    var negativo: Double = 0.0
    var total: Double = 0.0

    fun seila() {
        val element = Gasto("perdi na rua a 20 anos atras", 20.0, "12/05/2010", false)
        val element1 = Gasto("ganhei de aniversario da familia no ano passado", 50.0, "15/08/2020", true)

        listinha.add(element1)
        listinha.add(element)
        listinha.add(element1)

        total = positivo + negativo

        Log.i("TAG", listinha.toString())

        somaGastos()
    }

    fun add(gasto: Gasto) {
        listinha.add(gasto)
    }

    fun remove(gasto: Gasto) {
        listinha.remove(gasto)

    }

    fun somaGastos() {
        listinha.forEach {
            if (it.ganhou) {
                positivo += it.valor
            } else {
                negativo -= it.valor
            }
        }
        total = positivo + negativo
    }
}