package com.example.myweatherapp.adapter

import com.example.myweatherapp.model.Forecast

interface WeatherClickListener {

    fun onWeatherClicked(forecast: Forecast)
}