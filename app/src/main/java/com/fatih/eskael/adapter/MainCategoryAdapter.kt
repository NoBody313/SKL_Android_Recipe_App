package com.fatih.eskael.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatih.eskael.R
import com.fatih.eskael.entities.Recipes
import kotlinx.android.synthetic.main.rv_list_sec_category.view.*

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    private var arrMainCategory = ArrayList<Recipes>()

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setData(arrData: List<Recipes>) {
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_list_main_category, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_name_dishes.text = arrMainCategory[position].nameDish
    }
}