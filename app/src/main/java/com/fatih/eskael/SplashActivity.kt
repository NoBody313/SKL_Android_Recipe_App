package com.fatih.eskael

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fatih.eskael.entities.Category
import com.fatih.eskael.interfaces.GetDataService
import com.fatih.eskael.retrofitClient.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnGetStarted.setOnClickListener {
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories() {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : Callback<List<Category>> {

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                insertDataIntoRoomDb(response.body())
            }
        })
    }

    fun insertDataIntoRoomDb(category: List<Category>?) {}
}