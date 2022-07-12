package com.example.contatos

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment

class ContatoListFragment:
    ListFragment(),
    ContatosListView{

    private val presenter = ContatoListPresenter(this, MemoryRepository)

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        presenter.searchContatos("")
    }

    override fun showContatos(contatos: List<Contato>) {

        val adapter = ArrayAdapter<Contato>(requireContext(), android.R.layout.simple_list_item_1, contatos)

        listAdapter = adapter
    }

    override fun showContatosDetails(contato: Contato) {
        TODO("Not yet implemented")
    }
}