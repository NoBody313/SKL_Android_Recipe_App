package com.fatih.eskael.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fatih.eskael.entities.Category

@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM category ORDER BY id DESC")
    val getAllCategory: List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)
}