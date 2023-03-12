package com.flaviapaiva.cotacaomoedasimersao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnRecuperar: Button
    lateinit var tvBitcoin: TextView
    lateinit var tvEthereum: TextView

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