package com.example.myweatherapp.adapter

class WeatherConverter {

    fun convertKelvinToFahrenheit(kelvin: Double): Double{
        return (1.8 * (kelvin - 273)) + 32
    }

    fun formatDecimal(num: Double): String{
        return String.format("%.1f", num)
    }
}