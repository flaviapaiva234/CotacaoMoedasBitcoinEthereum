package com.flaviapaiva.cotacaomoedasimersao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.flaviapaiva.cotacaomoedasimersao.api.CotacaoApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var btnRecuperar: Button
    lateinit var tvBitcoin: TextView
    lateinit var tvEthereum: TextView

    val cotacaoAPI: CotacaoApi by lazy {      //import
        Retrofit.Builder()
            .baseUrl("https://www.mercadobitcoin.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create( CotacaoApi::class.java )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRecuperar = findViewById(R.id.btnRecuperar)
        tvBitcoin = findViewById(R.id.tvBitcoin)
        tvEthereum = findViewById(R.id.tvEthereum)

        btnRecuperar.setOnClickListener {

            //Precisa da Permissão a internet
            CoroutineScope( Dispatchers.IO).launch {

                val respostaBitcoin = cotacaoAPI.recuperarCotacaoBitcoin()
                if( respostaBitcoin.isSuccessful){
                    val corpoCotacaoBitcoin = respostaBitcoin.body()
                    if( corpoCotacaoBitcoin != null){

                       withContext( Dispatchers.Main) {
                           tvBitcoin.text = "Bitcoin R$ ${corpoCotacaoBitcoin.ticker.last}"
                       }

                    }
                }

            }

            //Precisa da Permissão a internet
            CoroutineScope( Dispatchers.IO).launch {

                val respostaEthereum = cotacaoAPI.recuperarCotacaoBitcoin()
                if( respostaEthereum.isSuccessful){
                    val corpoCotacaoEthereum = respostaEthereum.body()
                    if( corpoCotacaoEthereum != null){

                        withContext( Dispatchers.Main) {
                            tvEthereum.text = "Ethereum R$ ${corpoCotacaoEthereum.ticker.last}"
                        }

                    }
                }

            }

        }

    }
}