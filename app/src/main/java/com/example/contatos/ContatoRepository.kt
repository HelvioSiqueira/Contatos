package com.example.contatos

interface ContatoRepository {
    fun save(contato: Contato)
    fun remove(vararg contatos: Contato)
    fun contatoById(id: Long, callback: (Contato?) -> Unit)
    fun search(term: String, callback: (List<Contato>) -> Unit)
}