package com.Vitor5bonelli.orgs.base.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.Vitor5bonelli.orgs.R
import com.Vitor5bonelli.orgs.base.controller.ListaProdutosAdapter
import com.Vitor5bonelli.orgs.base.model.Produto
import com.Vitor5bonelli.orgs.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    private lateinit var amb : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        Toast.makeText(this, "Abriu o app!", Toast.LENGTH_SHORT).show()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(ctx = this, produtos = listOf(
            Produto(nome = "Canudinhos de Chocolate",
                    descricao = "BOM DIMAISSS!!!",
                    preco = BigDecimal("5.99")),

            Produto(nome = "Trakinas de Morango",
                descricao = "Caraca muita sdds!",
                preco = BigDecimal("2.99")),

            Produto(nome = "Bubbalo de TutiFruti",
                descricao = "slurp slurp",
                preco = BigDecimal("0.50")),

            Produto(nome = "Bolinho Ana Maria",
                descricao = "Esse eu enjoava...",
                preco = BigDecimal("3.50")),

        ))
    }


}