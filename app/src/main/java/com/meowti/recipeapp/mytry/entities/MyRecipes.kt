package com.meowti.recipeapp.mytry.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyRecipes")
data class MyRecipes(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "NameRecipe", collate = ColumnInfo.NOCASE) val nameRecipe: String?,
    @ColumnInfo(name = "Calories") val calories: Int?,
    @ColumnInfo(name = "Cooking time") val cookingTime: Int?,
    @ColumnInfo(name = "Favourite") val favourite: Boolean?,
    @ColumnInfo(name = "Picture") val pictureRecipes: Int?,
    @ColumnInfo(name = "Portions") val portions: Int,
    @ColumnInfo(name = "Ingredient Id") val ingredientID: List<Int>,
    @ColumnInfo(name = "Steps") val steps: List<String>,
    @ColumnInfo(name = "Tags Difficult") val tagDifficult: String,
    @ColumnInfo(name = "Tags Type") val tagType: String,
    @ColumnInfo(name = "Tags Time") val tagTime: String
)
