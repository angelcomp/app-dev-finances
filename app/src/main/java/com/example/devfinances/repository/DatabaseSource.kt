package com.example.devfinances.repository

import androidx.lifecycle.LiveData
import com.example.devfinances.database.GastoDao
import com.example.devfinances.models.Gasto

class DatabaseSource(
    private val gastoDao: GastoDao
) : GastoRepository {
    override fun todaLista(): LiveData<List<Gasto>> {
        return gastoDao.todaLista()
    }

    override suspend fun encontrarItem(id: Int): Gasto {
        return gastoDao.encontrarItem(id)
    }

    override suspend fun contarTodos(): Int {
        return contarTodos()
    }

    override suspend fun inserir(gasto: Gasto) {
        return gastoDao.inserir(gasto)
    }

    override suspend fun deletar(gasto: Gasto) {
        gastoDao.deletar(gasto)
    }
}