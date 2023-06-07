package com.example.arcadia.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arcadia.activity.TelaConfiguracaoCondomino
import com.example.arcadia.activity.TelaConfiguracaoPortaria
import com.example.arcadia.databinding.FragmentConfigBinding

class ConfigFragment : Fragment() {

    private lateinit var binding: FragmentConfigBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfigBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEditarPerfil.setOnClickListener {
            telaConfigMorador()
        }
    }

    fun telaConfigMorador() {
        val telaMorador =
            Intent(requireContext().applicationContext, TelaConfiguracaoCondomino::class.java)
        startActivity(telaMorador)
    }

    fun telaConfigPortaria() {
        val telaPortaria =
            Intent(requireContext().applicationContext, TelaConfiguracaoPortaria::class.java)
        startActivity(telaPortaria)
    }
}