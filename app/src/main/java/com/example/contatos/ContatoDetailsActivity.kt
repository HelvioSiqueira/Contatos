package com.example.contatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent

class ContatoDetailsActivity : AppCompatActivity() {
    private val contatoId: Long by lazy { intent.getLongExtra(EXTRA_CONTATO_ID, -1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_details)

        if(savedInstanceState == null){
            showContatoDetailsFragment()
        }
    }

    private fun showContatoDetailsFragment(){
        val fragment = ContatoDetailsFragment.newInstance(contatoId)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.details, fragment, ContatoDetailsFragment.TAG_DETAILS)
            .commit()
    }

    companion object{
        private const val EXTRA_CONTATO_ID = "contatoId"

        fun open(context: Context, contatoId: Long){
            context.startActivity(Intent(context, ContatoDetailsActivity::class.java).
            apply {
                putExtra(EXTRA_CONTATO_ID, contatoId)
            })
        }
    }
}