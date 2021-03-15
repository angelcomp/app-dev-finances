package com.example.devfinances.database

import android.app.Application
import com.example.devfinances.domain.Gasto
import com.example.devfinances.domain.Saldo
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.round
import kotlin.math.truncate

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
        var saldo: Saldo = Saldo(0.0, 0.0, 0.0)

        listinha.forEach {
            if (it.ganhou) {
                saldo.positivo += it.valor
            } else {
                saldo.negativo -= it.valor
            }
        }
        saldo.positivo = BigDecimal(saldo.positivo).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        saldo.negativo = BigDecimal(saldo.negativo).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        saldo.total = BigDecimal(saldo.positivo + saldo.negativo).setScale(2, RoundingMode.HALF_EVEN).toDouble()

        return saldo
    }
}