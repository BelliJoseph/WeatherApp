package com.example.myweatherapp.rest

import com.example.myweatherapp.model.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(FORECAST_PATH)
    suspend fun getForecast(
        @Query("appId") apiKey: String = API_KEY,
        @Query("q") city: String

    ): Response<Results>

    companion object{
        //https://api.openweathermap.org/data/2.5/forecast?appId=65d00499677e59496ca2f318eb68c049&q=Atlanta
        const val BASE_URL = "https://api.openweathermap.org/"
        private const val FORECAST_PATH= "data/2.5/forecast"

        private const val API_KEY = "65d00499677e59496ca2f318eb68c049"
    }
}