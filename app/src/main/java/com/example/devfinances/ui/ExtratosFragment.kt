package com.example.devfinances.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devfinances.adapter.ExtratosAdapter
import com.example.devfinances.databinding.FragmentExtratosBinding
import com.example.devfinances.domain.Gasto
import com.example.devfinances.viewModel.AppViewModel
import com.example.devfinances.viewModel.AppViewModelFactory

class ExtratosFragment : Fragment(), ExtratosAdapter.onItemClickListener {

    private var _binding: FragmentExtratosBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: ExtratosAdapter

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

        _binding = FragmentExtratosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.atualizarLista()

        viewModel.listinha.observe(viewLifecycleOwner, {
            setupRecyclerView(it)
        })
    }

    private fun setupRecyclerView(listinha: List<Gasto> = mutableListOf()) {
        adapter = ExtratosAdapter(listinha, this)
        binding.rvGastos.layoutManager = LinearLayoutManager(context)
        binding.rvGastos.setHasFixedSize(true)
        binding.rvGastos.adapter = adapter
    }

    override fun delete(position: Int) {
        viewModel.remove(position)
        setupRecyclerView()
    }
}