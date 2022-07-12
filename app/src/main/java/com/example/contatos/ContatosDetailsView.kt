package com.example.contatos

interface ContatosDetailsView {
    fun showContatoDetais(contato: Contato)
    fun errorContatoNotFound()
}