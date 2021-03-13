package com.example.devfinances.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.devfinances.database.GastoRepository
import com.example.devfinances.domain.Gasto
import com.example.devfinances.domain.Saldo
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GastoRepository(application)
    var listinha = MutableLiveData<List<Gasto>>()
    var saldo = MutableLiveData<Saldo>()

    fun atualizarLista() {
        viewModelScope.launch {
            listinha.value = repository.getAll()

            saldo.value = repository.somaGastos(listinha.value!!)
        }
    }

    fun add(gasto: Gasto) {
        viewModelScope.launch {
            repository.insert(gasto)
            atualizarLista()
        }
    }

    fun remove(position: Int) {
        viewModelScope.launch {
            val gasto = listinha.value!![position]
            repository.delete(gasto.id.toString())
            atualizarLista()
        }
    }
}