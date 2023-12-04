package com.Vitor5bonelli.orgs.base.dao

import com.Vitor5bonelli.orgs.base.model.Produto

class ProdutoDao {

    private val produtos = mutableListOf<Produto>()
    fun add(produto: Produto){
        produtos.add(produto)
    }

    fun getAll() : List<Produto>{
        return produtos.toList()
    }
}