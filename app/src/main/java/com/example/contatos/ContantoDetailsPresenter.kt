package com.example.contatos

class ContantoDetailsPresenter(private val view: ContatosDetailsView, private val repository: ContatoRepository) {

    fun loadContatoDetails(id: Long){
        repository.contatoById(id){contato ->
            if(contato != null){
                view.showContatoDetais(contato)
            } else {
                view.errorContatoNotFound()
            }
        }
    }
}