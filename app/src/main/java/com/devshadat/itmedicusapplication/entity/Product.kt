package com.devshadat.itmedicusapplication.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productTable")
class Product(
    @ColumnInfo(name = "title") val productTitle: String,
    @ColumnInfo(name = "subtitle") val productSubtitle: String,
    @ColumnInfo(name = "image") val productImage: String,
    @ColumnInfo(name = "created") val createdDate: String,
    @ColumnInfo(name = "stock") val isAvailable: Boolean
) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}