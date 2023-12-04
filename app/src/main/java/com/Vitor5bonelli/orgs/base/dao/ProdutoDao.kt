package com.Vitor5bonelli.orgs.base.dao

import com.Vitor5bonelli.orgs.base.model.Produto

class ProdutoDao {

    fun add(produto: Produto){
        Companion.produtos.add(produto)
    }

    fun getAll() : List<Produto>{
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}