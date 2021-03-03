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
import com.example.devfinances.ListaSingleton
import com.example.devfinances.adapter.ExtratosAdapter
import com.example.devfinances.domain.Gasto
import com.example.devfinances.viewModel.AppViewModel
import com.example.devfinances.viewModel.AppViewModelFactory

class ExtratosActivity : AppCompatActivity(), ExtratosAdapter.onItemClickListener {

    lateinit var binding: ActivityExtratoBinding
    lateinit var adapter: ExtratosAdapter

    val viewModel by lazy {
        ViewModelProvider(this, AppViewModelFactory())
            .get(AppViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtratoBinding.inflate(layoutInflater)
        setupRecyclerView()

        setContentView(binding.root)
    }

    private fun setupRecyclerView() {
        adapter = ExtratosAdapter(ListaSingleton.lista, this)
        binding.rvGastos.layoutManager = LinearLayoutManager(this)
        binding.rvGastos.setHasFixedSize(true)
        binding.rvGastos.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun delete(position: Int) {
        viewModel.remove(position)
        setupRecyclerView()
    }
}