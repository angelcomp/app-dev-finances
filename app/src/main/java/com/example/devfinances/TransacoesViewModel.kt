package com.example.devfinances

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devfinances.models.Gasto
import com.example.devfinances.repository.GastoRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class TransacoesViewModel(
    private val repository: GastoRepository
): ViewModel() {

    fun addGasto(gasto: Gasto) = viewModelScope.launch {
        try {
            repository.inserir(gasto)
        }catch (ex: Exception) {
            Log.e("deu erro no add", ex.toString(), )
        }
    }
}