package com.Vitor5bonelli.orgs.base.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.Vitor5bonelli.orgs.R
import com.Vitor5bonelli.orgs.base.model.Produto

class ListaProdutosAdapter(
    private val ctx: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincular(produto: Produto) {
            val title = itemView.findViewById<TextView>(R.id.titleTV)
            val desc = itemView.findViewById<TextView>(R.id.descriptionTV)
            val price = itemView.findViewById<TextView>(R.id.priceTV)

            title.text = produto.nome
            desc.text = produto.descricao
            price.text = produto.preco.toPlainString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincular(produto)
    }

    override fun getItemCount(): Int = produtos.size
    fun update(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}
