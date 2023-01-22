package com.fatih.eskael

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatih.eskael.adapter.MainCategoryAdapter
import com.fatih.eskael.adapter.SecCategoryAdapter
import com.fatih.eskael.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private val arrMainCategory = ArrayList<Recipes>()
    private val arrSecCategory = ArrayList<Recipes>()

    private val mainCategoryAdapter = MainCategoryAdapter()
    private val secCategoryAdapter = SecCategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Temp Data
        arrMainCategory.add(Recipes(1, "Beef"))
        arrMainCategory.add(Recipes(2, "Chicken"))
        arrMainCategory.add(Recipes(3, "Dessert"))
        arrMainCategory.add(Recipes(4, "Lamb"))

        mainCategoryAdapter.setData(arrMainCategory)

        arrSecCategory.add(Recipes(1, "Beef and mustard pie"))
        arrSecCategory.add(Recipes(2, "Chicken and mushroom hotpot"))
        arrSecCategory.add(Recipes(3, "Banana pancakes"))
        arrSecCategory.add(Recipes(4, "Lamb Curry"))

        secCategoryAdapter.setData(arrSecCategory)

        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_main.adapter = mainCategoryAdapter

        rv_sec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_sec.adapter = secCategoryAdapter

    }
}