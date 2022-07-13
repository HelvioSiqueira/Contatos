package com.example.contatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContatoActivity : AppCompatActivity(), ContatoListFragment.OnContatoClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
    }

    override fun onContatoClick(contato: Contato) {
        showDetailsActivity(contato.id)
    }

    private fun showDetailsActivity(contatoId: Long){
        ContatoDetailsActivity.open(this, contatoId)
    }
}