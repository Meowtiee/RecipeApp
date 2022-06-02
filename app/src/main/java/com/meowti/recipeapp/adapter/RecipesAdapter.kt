package com.meowti.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meowti.recipeapp.R
import com.meowti.recipeapp.mytry.entities.MyRecipes
import kotlinx.android.synthetic.main.item_rv_main_category.view.*

class RecipesAdapter: RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    var arrRecipes = ArrayList<MyRecipes>()
    class RecipeViewHolder(view:View): RecyclerView.ViewHolder(view){
    }

    fun setData(arrData : List<MyRecipes>){
        arrRecipes = arrData as ArrayList<MyRecipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.title_textView.text = arrRecipes[position].nameRecipe
    }

    override fun getItemCount(): Int {
        return arrRecipes.size
    }
}
