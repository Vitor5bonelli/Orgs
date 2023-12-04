package com.Vitor5bonelli.orgs.base.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.Vitor5bonelli.orgs.R
import com.Vitor5bonelli.orgs.base.controller.ListaProdutosAdapter
import com.Vitor5bonelli.orgs.base.dao.ProdutoDao
import com.Vitor5bonelli.orgs.databinding.ActivityListaProdutosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity() {
    private lateinit var alpb: ActivityListaProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alpb = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(alpb.root)

        Toast.makeText(this, "Abriu o app!", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        val dao = ProdutoDao()

        val recyclerView = alpb.recyclerView
        recyclerView.adapter = ListaProdutosAdapter(ctx = this, produtos = dao.getAll())

        // Trocando de view
        val fab = alpb.floatingActionButton
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }


}