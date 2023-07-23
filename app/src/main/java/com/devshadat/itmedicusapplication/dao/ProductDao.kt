package com.devshadat.itmedicusapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devshadat.itmedicusapplication.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("Select * from productTable order by id ASC")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("Select * from productTable order by id ASC")
    fun readData(): Flow<List<Product>>

    @Query("Select * from productTable where title like :searchQuery or subtitle like :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Product>>
}