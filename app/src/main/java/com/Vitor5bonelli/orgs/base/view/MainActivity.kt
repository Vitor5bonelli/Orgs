package com.Vitor5bonelli.orgs.base.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.Vitor5bonelli.orgs.R
import com.Vitor5bonelli.orgs.base.controller.ListaProdutosAdapter
import com.Vitor5bonelli.orgs.base.dao.ProdutoDao
import com.Vitor5bonelli.orgs.base.model.Produto
import com.Vitor5bonelli.orgs.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    private lateinit var amb : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        Toast.makeText(this, "Abriu o app!", Toast.LENGTH_SHORT).show()

        val dao = ProdutoDao()
        
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(ctx = this, produtos = dao.getAll())

        // Trocando de view
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }


}