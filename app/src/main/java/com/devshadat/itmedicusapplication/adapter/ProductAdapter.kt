package com.devshadat.itmedicusapplication.adapter

import android.R
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.devshadat.itmedicusapplication.entity.Product
import java.util.*


class ProductAdapter(
    val context: Context,
    val noteClickDeleteInterface: NoteClickDeleteInterface,
    val noteClickInterface: NoteClickInterface
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var rand: Random = Random()

    // on below line we are creating a
    // variable for our all notes list.
    private val allProducts = ArrayList<Product>()

    // on below line we are creating a view holder class.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are creating an initializing all our
        // variables which we have added in layout file.
        val productTitle =
            itemView.findViewById<TextView>(com.devshadat.itmedicusapplication.R.id.product_title)
        val productImage =
            itemView.findViewById<TextView>(com.devshadat.itmedicusapplication.R.id.product_img)
        val productSubtitle =
            itemView.findViewById<TextView>(com.devshadat.itmedicusapplication.R.id.product_subtitle)
//        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflating our layout file for each item of recycler view.
        val itemView = LayoutInflater.from(parent.context).inflate(
            com.devshadat.itmedicusapplication.R.layout.product_item,
            parent, false
        )
        val tv: TextView =
            itemView.findViewById(com.devshadat.itmedicusapplication.R.id.product_img)
        val red = rand.nextInt(200 - 1)
        val green = rand.nextInt(200 - 1)
        val blue = rand.nextInt(200 - 1)
        tv.setBackgroundColor(Color.rgb(red, green, blue))
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // on below line we are setting data to item of recycler view.
        holder.productTitle.setText(allProducts.get(position).productTitle)
        holder.productImage.setText(allProducts.get(position).productTitle)
        holder.productSubtitle.setText(allProducts.get(position).productSubtitle)
        /*  holder.dateTV.setText("Last Updated : " + allProducts.get(position).createdDate)
          // on below line we are adding click listener to our delete image view icon.
          holder.deleteIV.setOnClickListener {
              // on below line we are calling a note click
              // interface and we are passing a position to it.
              noteClickDeleteInterface.onDeleteIconClick(allProducts.get(position))
          }*/

        // on below line we are adding click listener
        // to our recycler view item.
        holder.itemView.setOnClickListener {
            // on below line we are calling a note click interface
            // and we are passing a position to it.
            noteClickInterface.onNoteClick(allProducts.get(position))
        }
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our list size.
        return allProducts.size
    }

    // below method is use to update our list of notes.
    fun updateList(newList: List<Product>) {
        // on below line we are clearing
        // our notes array list
        allProducts.clear()
        // on below line we are adding a
        // new list to our all notes list.
        allProducts.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }
}

interface NoteClickDeleteInterface {
    // creating a method for click
    // action on delete image view.
    fun onDeleteIconClick(note: Product)
}

interface NoteClickInterface {
    // creating a method for click action
    // on recycler view item for updating it.
    fun onNoteClick(note: Product)
}