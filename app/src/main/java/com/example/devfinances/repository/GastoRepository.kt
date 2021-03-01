package com.example.devfinances.repository

import androidx.lifecycle.LiveData
import com.example.devfinances.models.Gasto

interface GastoRepository {

    fun todaLista(): LiveData<List<Gasto>>

    suspend fun  encontrarItem(id: Int): Gasto

    suspend fun contarTodos(): Int

    suspend fun inserir(gasto: Gasto)

    suspend fun deletar(gasto: Gasto)
}