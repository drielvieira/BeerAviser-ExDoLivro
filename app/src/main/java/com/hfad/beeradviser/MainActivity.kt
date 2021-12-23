package com.hfad.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer) // o botão que o usuario vai clicar

        /// aqui é o que acontece quando o usuario clica no botão
        /// esse método recebe uma lambda
        // adiciona onClickListener ao botão (escutar)
        findBeer.setOnClickListener {

            // aqui é o spinner de cores
            val beerColor = findViewById<Spinner>(R.id.beer_color)  // o spinner de cores

            /// pega o item selecionado do spinner
            val color = beerColor.selectedItem

            // salvando o método getBeers nessa variavel
            val beerList = getBeers(color.toString())  // converte para a valor desejadl -> (string)

            // construir uma string exibindo cada cerveja em uma nova linha
            val beers = beerList.reduce {str, item -> str + '\n' + item}

            val brands = findViewById<TextView>(R.id.brands)  // TextView aparece a lista de cerveja

            brands.text = beers  // atualiza a propriedade de texto da visualização
        }
    }
        // adiciona o método getBeers() a MainActivity
        // método getBeers vai retorna essa lista de cervejas
    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Bear", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}