package com.example.myweatherapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myweatherapp.R
import com.example.myweatherapp.adapter.convertKelvinToFahrenheit
import com.example.myweatherapp.adapter.formatDecimal
import com.example.myweatherapp.databinding.FragmentForecastDetailsBinding

class ForecastDetailsFragment : BaseFragment() {

    private val binding by lazy{
        FragmentForecastDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val chosenCity = weatherViewModel.userChoice
        val chosenForecast = weatherViewModel.forecastChoice

        chosenCity?.let {
            val upperCityName = (it[0].uppercaseChar() + it.substring(1))
            binding.detailsCityName.text = upperCityName
        }

        chosenForecast?.let {
            binding.detailsTime.text = it.dtTxt

            val tempChange = it.main.temp.convertKelvinToFahrenheit()
            val formatTemp = tempChange.formatDecimal() + "\u2109"
            binding.detailsTemp.text = formatTemp

            val feelsLikeChange = it.main.feelsLike.convertKelvinToFahrenheit()
            val formatFeelsLike = feelsLikeChange.formatDecimal() + "\u2109"
            binding.detailsFeelsLike.text = formatFeelsLike

            binding.detailsRain.text = it.rain.toString()

            val formatWind = it.wind.speed.formatDecimal() + "mph"
            binding.detailsWindSpeed.text = formatWind

            val formatGust = it.wind.gust.formatDecimal() + "mph"
            binding.detailsWindGust.text = formatGust
        }

        binding.detailsBackButton.setOnClickListener{
            findNavController().navigate(R.id.action_DetailsFragment_to_ForecastFragment2)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}