package com.fatih.eskael.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fatih.eskael.dao.RecipeDao
import com.fatih.eskael.entities.Category
import com.fatih.eskael.entities.CategoryItem
import com.fatih.eskael.entities.Recipes
import com.fatih.eskael.entities.converter.CategoryListConverter

@Database(
    entities = [Recipes::class, CategoryItem::class, Category::class, CategoryListConverter::class],
    version = 1,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {

    companion object {
        var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipesDatabase != null) {

                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao(): RecipeDao
}