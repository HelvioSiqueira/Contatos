package com.example.contatos

interface ContatosListView {
    fun showContatos(contatos: List<Contato>)
    fun showContatosDetails(contato: Contato)
}