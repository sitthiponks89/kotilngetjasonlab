package com.sitthipon.kotlingetjsonleb.Interface

import com.sitthipon.kotlingetjsonleb.Model.Product
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("products")
    fun getProductList(): Call<MutableList<Product>>

}