package com.sitthipon.kotlingetjsonleb.Commom

import com.sitthipon.kotlingetjsonleb.Interface.RetrofitService
import com.sitthipon.kotlingetjsonleb.Retrofit.RetrofitClient

object Commom {

    private val BASE_URL = "https://ecommerce-product-app.herokuapp.com/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

}