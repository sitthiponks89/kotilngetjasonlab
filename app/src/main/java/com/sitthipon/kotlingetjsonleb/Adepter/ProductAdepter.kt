package com.sitthipon.kotlingetjsonleb.Adepter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.sitthipon.kotlingetjsonleb.Model.Product
import com.sitthipon.kotlingetjsonleb.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.products_detail.view.*


class ProductAdepter (private val context: Context, private val productList: MutableList<Product>) : RecyclerView.Adapter<ProductAdepter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_product_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
         return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(productList[position].image).into(holder.image_product)
        holder.txt_detail.text = productList[position].title
        holder.txt_price.text = productList[position].price

    }

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image_product : ImageView
        var txt_detail : TextView
        var txt_price : TextView

        init {
            image_product = itemView.image_product
            txt_detail = itemView.txt_detail
            txt_price = itemView.txt_price
        }

    }

}