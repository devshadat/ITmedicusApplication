package com.devshadat.itmedicusapplication.repository

import androidx.lifecycle.LiveData
import com.devshadat.itmedicusapplication.dao.ProductDao
import com.devshadat.itmedicusapplication.entity.Product
import kotlinx.coroutines.flow.Flow

class ProductRepository(private val productDao: ProductDao) {

    val allBanners: LiveData<List<Product>> = productDao.getAllProducts()

    fun readData(): Flow<List<Product>> {
        return productDao.readData()
    }

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    suspend fun delete(product: Product) {
        productDao.delete(product)
    }

    suspend fun update(product: Product) {
        productDao.update(product)
    }

    fun searchDatabase(searchQuery: String): Flow<List<Product>> {
        return productDao.searchDatabase(searchQuery)
    }
}