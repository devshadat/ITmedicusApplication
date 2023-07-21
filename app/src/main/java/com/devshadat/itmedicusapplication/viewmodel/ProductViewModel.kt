package com.devshadat.itmedicusapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.devshadat.itmedicusapplication.database.ProductDatabase
import com.devshadat.itmedicusapplication.entity.Product
import com.devshadat.itmedicusapplication.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    val allProducts: LiveData<List<Product>>
    val repository: ProductRepository

    init {
        val dao = ProductDatabase.getDatabase(application).getBannerDao()
        repository = ProductRepository(dao)
        allProducts = repository.allBanners
    }

    fun deleteNote(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(product)
    }

    fun updateNote(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(product)
    }

    fun addNote(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(product)
    }
}