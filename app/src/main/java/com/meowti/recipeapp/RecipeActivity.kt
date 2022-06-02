package com.meowti.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.meowti.recipeapp.adapter.VpAdapter
import com.meowti.recipeapp.databinding.ActivityRecipeBinding
import com.meowti.recipeapp.fragments.FragmentIngredient
import com.meowti.recipeapp.fragments.FragmentRecipe

class RecipeActivity : AppCompatActivity() {
    private val fragList = listOf(FragmentIngredient.newInstance(), FragmentRecipe.newInstance(), FragmentCooking.newInstance())
    private val fragListTitles = listOf("Ингредиенты", "Рецепт", "Готовить")
    private lateinit var binding: ActivityRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = VpAdapter(this, fragList)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tablayoutRecipe, binding.viewPager2){
            tab, pos -> tab.text = fragListTitles[pos]
        }.attach()
    }
}