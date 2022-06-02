package com.meowti.recipeapp.mytry.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient")
data class MyIngredient(
    @PrimaryKey(autoGenerate = false) val id:Int = 0,
    @ColumnInfo(name = "NameIngredient") val nameIngredient: String = "",
    @ColumnInfo(name = "QuantityIngredient") val quantityIngredient: Long = 0
  )
