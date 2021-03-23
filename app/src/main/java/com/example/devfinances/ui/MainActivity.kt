package com.example.devfinances.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.devfinances.R
import com.example.devfinances.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        Thread.sleep(2500)
        setTheme(R.style.Theme_Devfinances)

        setContentView(binding.root)
    }
}