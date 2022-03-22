package com.example.myweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myweatherapp.databinding.ActivityMainBinding
import com.example.myweatherapp.databinding.ForecastItemBinding
import com.example.myweatherapp.model.Forecast

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.myNavContainer)
        setupActionBarWithNavController(navController)

        supportActionBar?.hide()

    }

}