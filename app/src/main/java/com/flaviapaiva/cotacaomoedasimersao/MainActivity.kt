package com.flaviapaiva.cotacaomoedasimersao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.flaviapaiva.cotacaomoedasimersao.api.CotacaoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var btnRecuperar: Button
    lateinit var tvBitcoin: TextView
    lateinit var tvEthereum: TextView

    val cotacaoApi: CotacaoApi by lazy {      //iomport
        Retrofit.Builder()
            .baseUrl("https://www.mercadobitcoin.net/api/BTC/ticker/")
            .baseUrl("https://www.mercadobitcoin.net/api/ETH/ticker/")
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

        }

    }
}