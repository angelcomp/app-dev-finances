package com.example.devfinances.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devfinances.databinding.ActivityExtratoBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devfinances.adapter.ExtratosAdapter
import com.example.devfinances.domain.Gasto
import com.example.devfinances.viewModel.AppViewModel
import com.example.devfinances.viewModel.AppViewModelFactory

class ExtratosActivity : AppCompatActivity() {

    lateinit var binding: ActivityExtratoBinding
    //val viewModel: MainViewModel by viewModels()
    val viewModel by lazy {
        ViewModelProvider(this, AppViewModelFactory())
            .get(AppViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtratoBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.seila()
        binding.rvGastos.layoutManager = LinearLayoutManager(this)
        binding.rvGastos.setHasFixedSize(true)
        binding.rvGastos.adapter = ExtratosAdapter(viewModel.listinha)
    }
}