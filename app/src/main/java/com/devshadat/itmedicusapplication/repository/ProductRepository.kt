package com.devshadat.itmedicusapplication.repository

import androidx.lifecycle.LiveData
import com.devshadat.itmedicusapplication.dao.ProductDao
import com.devshadat.itmedicusapplication.entity.Product

class ProductRepository(private val productDao: ProductDao) {

    val allBanners: LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    suspend fun delete(product: Product) {
        productDao.delete(product)
    }

    suspend fun update(product: Product) {
        productDao.update(product)
    }
}