package com.example.contatos

class ContatoListPresenter(private val view: ContatosListView, private val repository: ContatoRepository) {

    fun searchContatos(term: String){
        repository.search(term){ contatos ->
            view.showContatos(contatos)
        }
    }

    fun showContatoDetails(contato: Contato){
        view.showContatosDetails(contato)
    }
}