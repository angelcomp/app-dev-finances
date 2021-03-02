package com.example.devfinances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.devfinances.databinding.ActivityExtratoBinding

class ExtratoActivity : AppCompatActivity() {

    lateinit var binding: ActivityExtratoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtratoBinding.inflate(layoutInflater)



        setContentView(binding.root)
    }
}