package com.digitalhouse.dhwallet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.CompanyAdapter
import com.digitalhouse.dhwallet.adapter.ContactAdapter
import com.digitalhouse.dhwallet.model.Company
import com.digitalhouse.dhwallet.model.CompanyType
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType


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

        val entradaView = view.findViewById<TextView>(R.id.input_value)
        entrada?.let {
            entradaView.text = it
        }

        val saidaView = view.findViewById<TextView>(R.id.output_value)
        saida?.let {
            saidaView.text = it
        }

        val listTransaction = MutableList (5){
            Company(
                type = CompanyType.RECEBIMENTO,
                name = "Dribble.Inc",
                image = "https://png.pngtree.com/png-vector/20191027/ourmid/pngtree-sports-basket-ball-vector-png-png-image_1874392.jpg",
                valueCompany = "+ R$ 45"
            );
        }
        listTransaction.add(
            Company(
                type = CompanyType.PAGAMENTO,
                name = "Spotify Family",
                image = "data:image/png;base64,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",
                valueCompany = "- R$ 163 "
            )
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_transaction)
        recyclerView.adapter = CompanyAdapter(listTransaction)


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