package com.example.myweatherapp.adapter

fun Double.convertKelvinToFahrenheit(): Double {
    return (1.8 * (this - 273)) + 32
}

fun Double.formatDecimal(): String {
    return String.format("%.1f", this)
}