package com.example.devfinances.ui

import android.annotation.SuppressLint
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
import java.lang.Exception
import java.text.SimpleDateFormat
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
            val gasto = informacoesGasto()

            if (gasto == -1) {
                Toast.makeText(this, "Preencha os campos corretamente!", Toast.LENGTH_LONG).show()
            } else {
                viewModel.add(gasto as Gasto)
                finish()
            }
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

        binding.btnCancelar.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }

    private fun informacoesGasto(): Any {
        try {
            if (binding.etDescricao.editText!!.text.toString().isNotEmpty()) {
                var data = calendario()
                if (data == "") {
                    val sdf = SimpleDateFormat("dd/M/yyyy")
                    data = sdf.format(Date())
                }

                return Gasto(
                    binding.etDescricao.editText!!.text.toString(),
                    binding.etValor.editText!!.text.toString().toDouble(),
                    data,
                    ganhou
                )
            } else {
                return -1
            }
        } catch (ex: Exception) {
            return -1
        }
    }

    private fun calendario(): String {
        val datePicker = binding.etData
        val today = Calendar.getInstance()

        datePicker.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            data = "$day/$month/$year"
        }
        return data
    }
}