package com.example.devfinances.database

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.devfinances.domain.Gasto
import com.example.devfinances.domain.Saldo
import java.lang.Exception

class GastoRepository(application: Application) {
    private val gastoDao: GastoDAO

    init {
        val db = GastoRoomDatabase.getDatabase(application)
        gastoDao = db.gastoDao()
    }

    suspend fun getAll(): List<Gasto> {
        return gastoDao.getAll()
    }

    suspend fun insert(gasto: Gasto) {
        gastoDao.insert(gasto)
    }

    suspend fun delete(id: String) {
        gastoDao.delete(id)
    }

    fun somaGastos(listinha: List<Gasto>): Saldo {
        var saldo: Saldo = Saldo(0.0,0.0,0.0)

        listinha.forEach {
            if (it.ganhou) {
                saldo.positivo += it.valor
            } else {
                saldo.negativo -= it.valor
            }
        }
        saldo.positivo = String.format("%.2f", saldo.positivo).toDouble()
        saldo.negativo = String.format("%.2f", saldo.negativo).toDouble()
        saldo.total = String.format("%.2f", (saldo.positivo + saldo.negativo)).toDouble()

        return saldo
    }
}