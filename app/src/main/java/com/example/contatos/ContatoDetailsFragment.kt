package com.example.contatos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contato_details.*

class ContatoDetailsFragment: Fragment(), ContatosDetailsView {
    private val presenter = ContatoDetailsPresenter(this, MemoryRepository)
    private var contato: Contato? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contato_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadContatoDetails(arguments?.getLong(EXTRA_CONTATO_ID, -1) ?: -1)
    }

    override fun showContatoDetais(contato: Contato) {
        this.contato = contato
        txtName.text = contato.name
        txtSobrenome.text = contato.sobrenome
        txtCelular.text = contato.telefone
        txtCidade.text = contato.cidade
    }

    override fun errorContatoNotFound() {
        txtName.text = getString(R.string.error_hotel_not_found)
        txtSobrenome.visibility = View.GONE
        txtCelular.visibility = View.GONE
        txtCidade.visibility = View.GONE
    }

    companion object{
        const val TAG_DETAILS = "tagDetalhe"
        private const val EXTRA_CONTATO_ID = "hotelId"

        fun newInstance(id: Long) = ContatoDetailsFragment().apply {
            arguments = Bundle().apply {
                putLong(EXTRA_CONTATO_ID, id)
            }
        }
    }
}