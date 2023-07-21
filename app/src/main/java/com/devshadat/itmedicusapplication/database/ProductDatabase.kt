package com.devshadat.itmedicusapplication.database

import android.content.Context
import android.provider.ContactsContract
import androidx.room.*
import com.devshadat.itmedicusapplication.dao.ProductDao
import com.devshadat.itmedicusapplication.entity.Product

@Database(
    entities = arrayOf(Product::class),
    version = 1,
    exportSchema = false
)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun getBannerDao(): ProductDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}