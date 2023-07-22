package com.devshadat.itmedicusapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devshadat.itmedicusapplication.adapter.NoteClickDeleteInterface
import com.devshadat.itmedicusapplication.adapter.NoteClickInterface
import com.devshadat.itmedicusapplication.adapter.ProductAdapter
import com.devshadat.itmedicusapplication.entity.Product
import com.devshadat.itmedicusapplication.viewmodel.ProductViewModel

class ProductActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface {

    lateinit var viewModal: ProductViewModel
    lateinit var notesRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        notesRV = findViewById(R.id.notesRV)

        // on below line we are initializing
        // all our variables.

        // on below line we are setting layout
        // manager to our recycler view.
        notesRV.layoutManager = LinearLayoutManager(this)

        // on below line we are initializing our adapter class.
        val noteRVAdapter = ProductAdapter(this, this, this)

        // on below line we are setting
        // adapter to our recycler view.
        notesRV.adapter = noteRVAdapter

        // on below line we are
        // initializing our view modal.
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(ProductViewModel::class.java)

        // on below line we are calling all notes method
        // from our view modal class to observer the changes on list.
        viewModal.allProducts.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                noteRVAdapter.updateList(it)
            }
        })

        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "Product cool",
                "demo product",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
    }

    override fun onDeleteIconClick(note: Product) {

    }

    override fun onNoteClick(note: Product) {

    }
}