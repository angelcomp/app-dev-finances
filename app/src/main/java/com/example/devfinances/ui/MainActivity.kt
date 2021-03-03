package com.example.devfinances.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.devfinances.ListaSingleton
import com.example.devfinances.ListaSingleton.negativo
import com.example.devfinances.ListaSingleton.positivo
import com.example.devfinances.ListaSingleton.total
import com.example.devfinances.databinding.ActivityMainBinding
import com.example.devfinances.domain.Gasto
import com.example.devfinances.viewModel.AppViewModel
import com.example.devfinances.viewModel.AppViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel by lazy {
        ViewModelProvider(this, AppViewModelFactory())
            .get(AppViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        binding.btnNovaTransacao.setOnClickListener {
            callTransacoes()
        }

        binding.btnConsulta.setOnClickListener {
            callExtrato()
        }

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.atualizarLista()
        binding.tvEntradas.text = "R$ ${positivo}0"
        binding.tvSaidas.text = "R$ ${negativo}0"
        binding.tvTotal.text = "R$ ${total}0"
        Toast.makeText(this, positivo.toString(), Toast.LENGTH_SHORT).show()
    }

    fun callExtrato() {
        val intent = Intent(this, ExtratosActivity::class.java)

        startActivity(intent)
    }

    fun callTransacoes() {
        val intent = Intent(this, TransacoesActivity::class.java)

        startActivity(intent)
    }
}