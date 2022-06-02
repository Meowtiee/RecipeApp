package com.meowti.recipeapp

import android.os.Bundle
import com.meowti.recipeapp.databinding.ActivityHomeBinding


class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}