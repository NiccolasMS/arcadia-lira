package com.example.arcadia.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.arcadia.R
import com.example.arcadia.activity.TelaLogin
import com.example.arcadia.databinding.FragmentNavegacaoBinding

class NavegacaoFragment : Fragment() {

    private lateinit var binding: FragmentNavegacaoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNavegacaoBinding.inflate(inflater)
        inflater.inflate(R.layout.fragment_navegacao, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivHome.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.fragment_tela_principal, HomeFragment(), "FRAGMENT_HOME")
            transaction.commit()
        }

        binding.ivChat.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(
                R.id.fragment_tela_principal,
                EncomendaFragment(),
                "FRAGMENT_CHAT"
            )
            transaction.commit()
        }

        binding.ivConfig.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.fragment_tela_principal, ConfigFragment(), "FRAGMENT_CONFIG")
            transaction.commit()
        }

        binding.ivExit.setOnClickListener {
            val telaLogin =
                Intent(requireContext().applicationContext, TelaLogin::class.java)
            startActivity(telaLogin)
        }

        binding.ivAdd.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.fragment_tela_principal, FragmentAdicionarEncomenda(), "FRAGMENT_ADICIONAR_ENCOMENDA")
            transaction.commit()
        }

    }

}
