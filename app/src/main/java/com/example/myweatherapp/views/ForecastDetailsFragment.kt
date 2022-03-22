package com.example.myweatherapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myweatherapp.MainActivity
import com.example.myweatherapp.R
import com.example.myweatherapp.adapter.WeatherConverter
import com.example.myweatherapp.databinding.FragmentForecastDetailsBinding
import com.example.myweatherapp.model.Forecast

class ForecastDetailsFragment : BaseFragment() {

    private val binding by lazy{
        FragmentForecastDetailsBinding.inflate(layoutInflater)
    }

    private val weatherConverter by lazy{
        WeatherConverter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val chosenCity = weatherViewModel.userChoice
        val chosenForecast = weatherViewModel.forecastChoice

        val upperCityName = (chosenCity!![0].uppercaseChar() + chosenCity!!.substring(1))
        binding.detailsCityName.text = upperCityName
        binding.detailsTime.text = chosenForecast!!.dtTxt.toString()

        val tempChange = weatherConverter.convertKelvinToFahrenheit(
             chosenForecast!!.main.temp
        )
        val formatTemp = weatherConverter.formatDecimal(tempChange) + "\u2109"
        binding.detailsTemp.text = formatTemp

        val feelsLikeChange = weatherConverter.convertKelvinToFahrenheit(
            chosenForecast!!.main.feelsLike
        )
        val formatFeelsLike = weatherConverter.formatDecimal(feelsLikeChange) + "\u2109"
        binding.detailsFeelsLike.text = formatFeelsLike

        binding.detailsRain.text = chosenForecast!!.rain.toString()

        val formatWind = weatherConverter.formatDecimal(chosenForecast!!.wind.speed) + "mph"
        binding.detailsWindSpeed.text = formatWind

        val formatGust = weatherConverter.formatDecimal(chosenForecast!!.wind.gust) + "mph"
        binding.detailsWindGust.text = formatGust

        binding.detailsBackButton.setOnClickListener{
            findNavController().navigate(R.id.action_DetailsFragment_to_ForecastFragment2)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


    companion object {

        fun newInstance(param1: String, param2: String) = ForecastDetailsFragment()
    }
}