package com.example.devfinances.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.ViewModelProvider
import com.example.devfinances.databinding.ActivityExtratoBinding
import com.example.devfinances.databinding.ActivityTransacoesBinding
import com.example.devfinances.domain.Gasto
import com.example.devfinances.viewModel.AppViewModel
import com.example.devfinances.viewModel.AppViewModelFactory
import java.util.*

class TransacoesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransacoesBinding
    var data: String = ""
    private var ganhou: Boolean = false

    //val viewModel: MainViewModel by viewModels()
    val viewModel by lazy {
        ViewModelProvider(this, AppViewModelFactory())
            .get(AppViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransacoesBinding.inflate(layoutInflater)

        binding.btnSalvar.setOnClickListener {
            viewModel.add(informacoesGasto())
            viewModel.seila()

            Toast.makeText(this, viewModel.listinha.size.toString(), Toast.LENGTH_SHORT).show()
            finish()
        }

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

        calendario()

        binding.btnCancelar.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }

    private fun informacoesGasto(): Gasto {
        val descricao: String = binding.etDescricao.text.toString()
        val valor: Double = binding.etValor.text.toString().toDouble()
        val data: String = calendario()

        return Gasto(descricao, valor, data, ganhou)
    }

    private fun calendario(): String {
        val datePicker = binding.etData
        val today = Calendar.getInstance()

        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            data = "$day/$month/$year"
        }
        return data
    }
}