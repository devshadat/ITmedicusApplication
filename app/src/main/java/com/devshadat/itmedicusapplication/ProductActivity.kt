package com.devshadat.itmedicusapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devshadat.itmedicusapplication.adapter.NoteClickDeleteInterface
import com.devshadat.itmedicusapplication.adapter.NoteClickInterface
import com.devshadat.itmedicusapplication.adapter.ProductAdapter
import com.devshadat.itmedicusapplication.entity.Product
import com.devshadat.itmedicusapplication.viewmodel.ProductViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class ProductActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface,
    NavigationBarView.OnItemSelectedListener, SearchView.OnQueryTextListener {

    lateinit var viewModal: ProductViewModel
    lateinit var notesRV: RecyclerView
    lateinit var bottomNav: BottomNavigationView
    lateinit var searchView: SearchView
    lateinit var noteRVAdapter: ProductAdapter
    lateinit var homeIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        notesRV = findViewById(R.id.notesRV)
//        bottomNav = findViewById(R.id.bottomNavigationView)

//        bottomNav.selectedItemId = R.id.userProfile
        searchView = findViewById(R.id.search_bar)
        homeIcon = findViewById(R.id.homeIcon)
        searchView.setOnQueryTextListener(this)


        // on below line we are initializing
        // all our variables.

        // on below line we are setting layout
        // manager to our recycler view.
        notesRV.layoutManager = LinearLayoutManager(this)

        // on below line we are initializing our adapter class.
        noteRVAdapter = ProductAdapter(this, this, this)

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

        homeIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        viewModal.addNote(
            Product(
                "one",
                "this is bike",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "two",
                "powerful car",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )
        viewModal.addNote(
            Product(
                "three",
                "role model",
                "sfasf",
                "23,42,10",
                isAvailable = true
            )
        )

        viewModal.allProducts.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                noteRVAdapter.updateList(it)
            }
        })
    }

    override fun onDeleteIconClick(note: Product) {

    }

    override fun onNoteClick(note: Product) {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.mainPage -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                overridePendingTransition(0, 0)
                return true
            }
        }

        return false
    }

    override fun onQueryTextSubmit(text: String?): Boolean {
        if (text != null) {
            searchDatabase(text)
        }

        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        if (text != null) {
            searchDatabase(text)
        }

        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query"

        viewModal.searchDatabase(searchQuery).observe(this, Observer {
            it.let {
                noteRVAdapter.setData(it)
            }
        })
    }
}