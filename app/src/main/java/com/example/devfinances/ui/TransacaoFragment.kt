package com.example.devfinances.ui

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.devfinances.R
import com.example.devfinances.databinding.FragmentHomeBinding
import com.example.devfinances.databinding.FragmentTransacaoBinding
import com.example.devfinances.domain.Gasto
import com.example.devfinances.viewModel.AppViewModel
import com.example.devfinances.viewModel.AppViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class TransacaoFragment : Fragment() {

    var data: String = ""
    private var ganhou: Boolean = false

    private var _binding: FragmentTransacaoBinding? = null
    private val binding get() = _binding!!

    lateinit var application: Application
    val viewModel by lazy {
        ViewModelProvider(this, AppViewModelFactory(application))
            .get(AppViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        application = requireActivity().getApplication()!!

        _binding = FragmentTransacaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSalvar.setOnClickListener {
            val gasto = informacoesGasto()

            if (gasto == -1) {
                Toast.makeText(context, "Preencha os campos corretamente!", Toast.LENGTH_LONG).show()
            } else {
                viewModel.add(gasto as Gasto)
                findNavController().popBackStack()
            }
        }

        binding.ganhei.setOnClickListener {
            ganhou = true
        }
        binding.gastei.setOnClickListener {
            ganhou = false
        }

        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun informacoesGasto(): Any {
        try {
            if (binding.etDescricao.editText!!.text.toString().isNotEmpty()) {
                var data = calendario()

                return Gasto(
                    null,
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

   fun calendario(): String {
        val datePicker = binding.etData

        val day = datePicker.dayOfMonth
        val month = datePicker.month + 1
        val year = datePicker.year

        return "$day/$month/$year"
    }
}