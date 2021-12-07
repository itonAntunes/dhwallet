package com.digitalhouse.dhwallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val ARG_ENTRADA = "arg_entrada"
private const val ARG_SAIDA = "arg_saida"

class TransactionFragment : Fragment(R.layout.fragment_transaction) {

    private var entrada: String? = null
    private var saida: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            entrada = it.getString(ARG_ENTRADA)
            saida = it.getString(ARG_SAIDA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entradaView = view.findViewById<TextView>(R.id.entrada)
        entrada?.let {
            entradaView.text = it
        }
    }

    companion object {
        fun newInstance(paramEntrada: String, paramSaida: String) =
            TransactionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ENTRADA, paramEntrada)
                    putString(ARG_SAIDA, paramSaida)
                }
            }
    }
}