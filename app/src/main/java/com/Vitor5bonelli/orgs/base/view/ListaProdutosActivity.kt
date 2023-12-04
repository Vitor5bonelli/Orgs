package com.Vitor5bonelli.orgs.base.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.Vitor5bonelli.orgs.base.controller.ListaProdutosAdapter
import com.Vitor5bonelli.orgs.base.dao.ProdutoDao
import com.Vitor5bonelli.orgs.databinding.ActivityListaProdutosBinding

class ListaProdutosActivity : AppCompatActivity() {
    private lateinit var alpb: ActivityListaProdutosBinding

    private val dao = ProdutoDao()
    private val adapter = ListaProdutosAdapter(ctx = this, produtos = dao.getAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alpb = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(alpb.root)

        configRecyclerView()

        Toast.makeText(this, "Abriu o app!", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        adapter.update(dao.getAll())

        // Trocando de view
        configFloatingActionButton()
    }

    private fun configFloatingActionButton() {
        val fab = alpb.floatingActionButton
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        val recyclerView = alpb.recyclerView
        recyclerView.adapter = adapter
    }


}