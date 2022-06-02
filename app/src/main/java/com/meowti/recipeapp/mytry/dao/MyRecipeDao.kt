package com.meowti.recipeapp.mytry.dao

import androidx.room.*
import com.meowti.recipeapp.mytry.entities.MyIngredient
import com.meowti.recipeapp.mytry.entities.MyRecipes

@Dao
interface MyRecipeDao {
    @Query("SELECT * FROM myRecipes ORDER BY id ASC")
    fun  getAllRecipes(): List<MyRecipes>

    @Query("SELECT * FROM ingredient")
    fun  getAllIngredients(): List<MyIngredient>

    @Query("SELECT * FROM MyRecipes WHERE `Tags Difficult` = :difficult")
    fun  findRecipesByDifficult(difficult: String): List<MyRecipes>

    @Query("SELECT * FROM MyRecipes WHERE `Tags Type` = :type")
    fun  findRecipesByType(type: String): List<MyRecipes>

    @Query("SELECT * FROM MyRecipes WHERE `Tags Time` = :time")
    fun  findRecipesByTime(time: String): List<MyRecipes>

    @Query("SELECT * FROM MyRecipes WHERE NameRecipe = :searchName")
    fun  findRecipesByName(searchName: String): List<MyRecipes>

    @Query("SELECT * FROM MyRecipes WHERE Favourite = :favourite")
    fun  findRecipesByFavourite(favourite: Boolean): List<MyRecipes>

    @Query("SELECT * FROM ingredient WHERE id = :id")
    fun getIngredientById(id: Int): MyIngredient

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRecipes(myRecipes: MyRecipes)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addIngredient(ingredient: MyIngredient)

    @Update
    fun updateRecipes(myRecipes: MyRecipes)

    @Delete
    fun deleteRecipe(myRecipes: MyRecipes)

}