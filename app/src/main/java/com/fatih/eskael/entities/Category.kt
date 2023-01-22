package com.fatih.eskael.entities

import androidx.room.*
import com.fatih.eskael.entities.converter.CategoryListConverter

@Entity(tableName = "Category")
data class Category(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "categoriesItem")
    @TypeConverters(CategoryListConverter::class)
    val categoriesItem: List<CategoryItem>? = null
)