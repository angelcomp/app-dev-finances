package com.example.devfinances

import com.example.devfinances.domain.Gasto

object ListaSingleton {
    var lista: MutableList<Gasto> = mutableListOf(
        Gasto("perdi na rua a 20 anos atras", 20.0, "12/05/2010", false),
        Gasto("ganhei da familia de aniversario no ano passado", 50.0, "15/08/2020", true)
    )

    var positivo: Double = 0.0
    var negativo: Double = 0.0
    var total: Double = 0.0
}