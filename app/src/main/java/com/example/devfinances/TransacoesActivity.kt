package com.example.devfinances

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.example.devfinances.databinding.ActivityTransacoesBinding
import java.util.*

class TransacoesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransacoesBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransacoesBinding.inflate(layoutInflater)

        val switch: SwitchCompat = binding.btnSwitch
        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switch.setText("Ganho")
            } else {
                switch.setText("Gasto")
            }
        }

        calendario()

        binding.btnCancelar.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }

    private fun calendario() {
        val datePicker = binding.etData
        val today = Calendar.getInstance()

        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            val data = "$day/$month/$year"
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
    }
}