package com.Vitor5bonelli.orgs.base.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.Vitor5bonelli.orgs.R
import com.Vitor5bonelli.orgs.base.dao.ProdutoDao
import com.Vitor5bonelli.orgs.base.model.Produto
import com.Vitor5bonelli.orgs.databinding.ActivityFormProductBinding
import com.Vitor5bonelli.orgs.databinding.ActivityListaProdutosBinding
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(){
    private lateinit var afpb: ActivityFormProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        afpb = ActivityFormProductBinding.inflate(layoutInflater)
        setContentView(afpb.root)

        val saveButton = afpb.saveBTN

        saveButton.setOnClickListener{
            val nameField = afpb.nameET
            val descField = afpb.descET
            val priceField = afpb.priceEt

            val name = nameField.text.toString()
            val desc = descField.text.toString()
            val priceText = priceField.text.toString()

            val price = if (priceText.isBlank()){
                BigDecimal.ZERO
            } else{
                BigDecimal(priceText)
            }

            val novoProduto = Produto(
                nome = name,
                descricao = desc,
                preco = price
            )

            val dao = ProdutoDao()
            dao.add(novoProduto)

            Toast.makeText(this, "$name foi adicionado!", Toast.LENGTH_LONG).show()
            Log.i("ListaDeProds", "${dao.getAll()}")
            finish()
        }
    }
}