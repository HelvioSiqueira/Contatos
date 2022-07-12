package com.example.contatos

data class Contato(
    var id: Long = 0,
    var name: String = "",
    var sobrenome: String = "",
    var telefone: String = "",
    var cidade: String = ""
){
    override fun toString(): String = "$name $sobrenome ($telefone)"
}
