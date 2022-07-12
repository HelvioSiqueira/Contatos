package com.example.contatos

object MemoryRepository: ContatoRepository {
    private var nextId = 1L
    private var contatosList = mutableListOf<Contato>()

    init {

        save(Contato(0, "Helvio", "Siqueira", "123456789", "São Luis"))
        save(Contato(0, "Felipe", "Pereira", "123456789", "Codó"))
        save(Contato(0, "Leo", "Coimbra", "123456789", "Caxias"))
        save(Contato(0, "Luquinhas", "Coimbra", "123456789", "Teresina"))
        save(Contato(0, "Hugo", "Caldini", "123456789", "Londrina"))
        save(Contato(0, "Paulo", "Caetano", "123456789", "São Paulo"))

    }

    override fun save(contato: Contato) {

        //Como o id é passado como 0 sempre cai nesse primeiro if
        if(contato.id == 0L){
            contato.id = nextId++

            contatosList.add(contato)

            //Esse else será usado para editar contatos
        } else {
            val index = contatosList.indexOfFirst { it.id == contato.id }

            if(index > -1){
                contatosList[index] = contato
            } else {
                contatosList.add(contato)
            }
        }
    }

    override fun remove(vararg contatos: Contato) {
        contatosList.removeAll(contatos)
    }

    override fun contatoById(id: Long, callback: (Contato?) -> Unit) {
        callback(contatosList.find{it.id == id})
    }

    override fun search(term: String, callback: (List<Contato>) -> Unit) {
        callback(
            if(term.isEmpty()) contatosList
            else contatosList.filter {
                it.name.uppercase().contains(term.uppercase())
            }
        )
    }
}