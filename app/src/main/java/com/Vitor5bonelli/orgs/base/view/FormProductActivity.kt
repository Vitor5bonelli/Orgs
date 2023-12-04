package com.Vitor5bonelli.orgs.base.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.Vitor5bonelli.orgs.R
import com.Vitor5bonelli.orgs.base.model.Produto
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saveButton = findViewById<Button>(R.id.saveBTN)
        saveButton.setOnClickListener{
            val nameField = findViewById<EditText>(R.id.nameET)
            val descField = findViewById<EditText>(R.id.descET)
            val priceField = findViewById<EditText>(R.id.priceEt)

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

            Toast.makeText(this, "$novoProduto", Toast.LENGTH_LONG).show()
        }
    }
}