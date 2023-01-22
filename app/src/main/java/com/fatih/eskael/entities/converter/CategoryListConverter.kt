package com.fatih.eskael.entities.converter

import androidx.room.TypeConverter
import com.fatih.eskael.entities.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<Category>): String? {
        return run {
            val gson = Gson()
            val type = object : TypeToken<Category>() {

            }.type
            gson.toJson(category, type)
        }
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<Category>? {
        return run {
            val gson = Gson()
            val type = object : TypeToken<Category>() {

            }.type
            gson.fromJson(categoryString, type)
        }
    }
}