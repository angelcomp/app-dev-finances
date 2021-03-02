package com.example.devfinances.extratos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.devfinances.databinding.ActivityExtratoBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devfinances.Gasto

class ExtratoActivity : AppCompatActivity() {

    lateinit var binding: ActivityExtratoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtratoBinding.inflate(layoutInflater)

        val element = Gasto("perdi na rua a 20 anos atras", 12.0, "12/05/2010")

        var lista = listOf(element, element, element, element, element, element)

        binding.rvGastos.layoutManager = LinearLayoutManager(this)
        binding.rvGastos.setHasFixedSize(true)
        binding.rvGastos.adapter = ExtratosAdapter(lista)


        Toast.makeText(this, lista.size.toString(), Toast.LENGTH_SHORT).show()

        setContentView(binding.root)
    }
}