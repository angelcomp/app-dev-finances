package com.example.devfinances.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.devfinances.R
import com.example.devfinances.databinding.FragmentHomeBinding
import com.example.devfinances.viewModel.AppViewModel
import com.example.devfinances.viewModel.AppViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.atualizarLista()

        binding.btnNovaTransacao.setOnClickListener {
            callTransacoes()
        }

        binding.btnConsulta.setOnClickListener {
            callExtrato()
        }

        viewModel.saldo.observe(viewLifecycleOwner, {
            binding.tvEntradas.text = String.format("R$ %.2f", it.positivo)
            binding.tvSaidas.text = String.format("R$ %.2f", it.negativo)
            binding.tvTotal.text = String.format("R$ %.2f", it.total)


        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.atualizarLista()
    }

    fun callExtrato() {
        findNavController().navigate(R.id.action_homeFragment_to_extratosFragment)
    }

    fun callTransacoes() {
        findNavController().navigate(R.id.action_homeFragment_to_transacaoFragment)
    }

}