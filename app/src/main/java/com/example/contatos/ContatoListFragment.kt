package com.example.contatos

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
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
        if(activity is OnContatoClickListener){
            val listener = activity as OnContatoClickListener
            listener.onContatoClick(contato)
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        val contato = l?.getItemAtPosition(position) as Contato
        presenter.showContatoDetails(contato)
    }

    interface OnContatoClickListener{
        fun onContatoClick(contato: Contato)
    }
}