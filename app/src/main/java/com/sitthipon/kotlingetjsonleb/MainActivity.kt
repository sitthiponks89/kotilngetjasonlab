package com.sitthipon.kotlingetjsonleb

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sitthipon.kotlingetjsonleb.Adepter.ProductAdepter
import com.sitthipon.kotlingetjsonleb.Commom.Commom
import com.sitthipon.kotlingetjsonleb.Interface.RetrofitService
import com.sitthipon.kotlingetjsonleb.Model.Product
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : ProductAdepter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Commom.retrofitService

        recyclerProductList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerProductList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()

    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getProductList().enqueue(object : Callback<MutableList<Product>> {
            override fun onFailure(call: Call<MutableList<Product>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Product>>, response: Response<MutableList<Product>>) {
                adapter = ProductAdepter(baseContext, response.body() as MutableList<Product>)
                adapter.notifyDataSetChanged()
                recyclerProductList.adapter = adapter

                dialog.dismiss()
            }

        })
    }


}