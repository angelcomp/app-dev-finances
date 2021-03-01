package com.example.devfinances

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.devfinances.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnNovaTransacao.setOnClickListener {
            callTransacoes()
        }

        setContentView(binding.root)
    }

    fun callTransacoes() {
        val intent = Intent(this, TransacoesActivity::class.java)

        startActivity(intent)
    }
}