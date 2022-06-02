package com.meowti.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meowti.recipeapp.databinding.ActivityHomeBinding
import com.meowti.recipeapp.databinding.ActivitySplashBinding
import com.meowti.recipeapp.mytry.database.MyRecipeDatabase
import com.meowti.recipeapp.mytry.sharedpreference.SharedPreferenceHelper
import kotlinx.android.synthetic.main.item_rv_main_category.view.*


class SplashActivity : AppCompatActivity() {
    private val myRecipesDao by lazy { MyRecipeDatabase.buildDataSource(this).MyRecipeDao() }
    private val sharedPreferenceHelper by lazy { SharedPreferenceHelper(this) }
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFirstTimeDatabase()
        setupTextViews()
    }

    private fun setupTextViews() {
        binding.rvMainCategory.title_textView.text = myRecipesDao.getAllRecipes()[0].nameRecipe
        myRecipesDao.getAllIngredients().forEach {
            binding.tvIngredients.text = binding.tvIngredients.text.toString() + "\n" + myRecipesDao.getIngredientById(it.id).nameIngredient
        }
    }

    private fun setupFirstTimeDatabase() {
        if (sharedPreferenceHelper.isFirstStart) {
            setupIngredients()
            setupRecipes()
            sharedPreferenceHelper.isFirstStart = false
        }
    }
    private fun setupIngredients() {
        myRecipesDao.addIngredient(
            Ingredient(
                id = 1,
                name = "Мясо",
                caloric = 228
            )
        )
        myRecipesDao.addIngredient(
            Ingredient(
                id = 2,
                name = "Ahaha",
                caloric = 1337
            )
        )
    }

    private fun setupRecipes() {
        myRecipesDao.addRecipe(
            Recipe(
                name = "Ahaha с мясом",
                ingredientsId = listOf(1, 2)
            )
        )
    }
}