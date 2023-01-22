package com.fatih.eskael.database

import android.content.Context
import androidx.room.*
import com.fatih.eskael.dao.RecipeDao
import com.fatih.eskael.entities.*
import com.fatih.eskael.entities.converter.CategoryListConverter
import com.fatih.eskael.entities.converter.MealListConverter

@Database(entities = [Recipes::class,CategoryItems::class,Category::class, Meal::class, MealsItems::class],version = 1,exportSchema = false)
@TypeConverters(CategoryListConverter::class, MealListConverter::class)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao():RecipeDao
}