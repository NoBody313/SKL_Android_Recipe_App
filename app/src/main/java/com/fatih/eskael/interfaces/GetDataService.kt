package com.fatih.eskael.interfaces

import com.fatih.eskael.entities.Meal
import com.fatih.eskael.entities.MealResponse
import com.fatih.eskael.entities.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpecificItem(@Query("i") id: String): Call<MealResponse>


}