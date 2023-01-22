package com.fatih.eskael.interfaces

import com.fatih.eskael.entities.Category
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("/categories.php")
    fun getCategoryList(): Call<List<Category>>
}