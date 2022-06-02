package com.meowti.recipeapp.mytry.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.meowti.recipeapp.mytry.converter.Converters
import com.meowti.recipeapp.mytry.dao.MyRecipeDao
import com.meowti.recipeapp.mytry.entities.MyIngredient
import com.meowti.recipeapp.mytry.entities.MyRecipes
import com.meowti.recipeapp.mytry.database.MyRecipeDatabase.Companion.DATABASE_VERSION

@Database(entities = [MyRecipes::class, MyIngredient::class], version = DATABASE_VERSION, exportSchema = false)

@TypeConverters(Converters::class)
abstract class MyRecipeDatabase: RoomDatabase() {
    abstract fun MyRecipeDao(): MyRecipeDao

    companion object{
        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "My-Recipes-Room"

        fun buildDataSource(context: Context): MyRecipeDatabase =
            Room.databaseBuilder(context, MyRecipeDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}