package com.flaviapaiva.cotacaomoedasimersao.api

import retrofit2.Response
import retrofit2.http.GET

interface CotacaoApi {

    // https://www.mercadobitcoin.net/api/  +  BTC/ticker/
    @GET("BTC/ticker/")
    suspend fun recuperarCotacaoBitcoin() : Response<Cotacao>     // fun Utilizar tarefas assiconas usando corroutines
    // Converte o arquivo Json Retornavel para Cotação


    // https://www.mercadobitcoin.net/api/  +  ETH/ticker/
    @GET("ETH/ticker/")
    suspend fun recuperarCotacaoEthereum() : Response<Cotacao>

}