package com.fatih.eskael.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatih.eskael.R
import com.fatih.eskael.entities.Recipes
import kotlinx.android.synthetic.main.rv_list_sec_category.view.*

class SecCategoryAdapter : RecyclerView.Adapter<SecCategoryAdapter.RecipeViewHolder>() {

    private var arrSecCategory = ArrayList<Recipes>()

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setData(arrData: List<Recipes>) {
        arrSecCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_list_sec_category, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrSecCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_name_dishes.text = arrSecCategory[position].nameDish
    }
}