package com.example.devfinances

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SwitchCompat
import com.example.devfinances.databinding.ActivityTransacoesBinding
import com.example.devfinances.models.Gasto
import java.util.*

class TransacoesActivity : AppCompatActivity() {

//    private val viewModel: TransacoesViewModel by viewModels {
//
//    }

    private lateinit var binding: ActivityTransacoesBinding
    var data: String = ""
    private var ganhou: Boolean = false
    private var lista = mutableListOf<Gasto>()

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransacoesBinding.inflate(layoutInflater)

        binding.btnSalvar.setOnClickListener {
            informacoesGasto()
        }

        calendario()

        binding.btnCancelar.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }

    private fun informacoesGasto() {
        val descricao: String = binding.etDescricao.text.toString()
        val valor: Double = binding.etValor.text.toString().toDouble()
        val data: String = calendario()

        val switch: SwitchCompat = binding.btnSwitch
        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switch.text = "Ganho"
                ganhou = true
            } else {
                switch.text = "Gasto"
                ganhou = false

            }
        }

        val gasto = Gasto(null, descricao, valor, data, ganhou)
        lista.add(gasto)

    }

    private fun calendario():String {
        val datePicker = binding.etData
        val today = Calendar.getInstance()

        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            data = "$day/$month/$year"
        }
        return data
    }
}