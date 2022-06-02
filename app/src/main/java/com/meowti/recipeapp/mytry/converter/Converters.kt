package com.meowti.recipeapp.mytry.converter

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromString(list: List<String>): String {
        return list.joinToString ("|")
    }

    @TypeConverter
    fun toString(data: String): List<Int> {
        return data.split("|").map {it.toInt()}
    }
}