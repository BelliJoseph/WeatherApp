package com.example.myweatherapp.views

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherapp.MainActivity
import com.example.myweatherapp.R
import com.example.myweatherapp.adapter.WeatherAdapter
import com.example.myweatherapp.adapter.WeatherClickListener
import com.example.myweatherapp.databinding.FragmentForecastBinding
import com.example.myweatherapp.model.Forecast
import com.example.myweatherapp.viewmodel.ResultState


class ForecastFragment : BaseFragment(), WeatherClickListener {

    private val binding by lazy{
        FragmentForecastBinding.inflate(layoutInflater)
    }

    private val weatherAdapter by lazy{
        WeatherAdapter(this)
    }

    private lateinit var cityName: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.myRecyclerView.apply{
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = weatherAdapter
        }

        cityName = weatherViewModel.userChoice.toString()

        weatherViewModel.cityForecast.observe(viewLifecycleOwner, ::handleState)

        weatherViewModel.getForecast(cityName)


        binding.forecastTitle.text = cityName + WEATHER

        binding.forecastBackButton.setOnClickListener{
            findNavController().navigate(R.id.action_ForecastFragment_to_SearchFragment2)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun handleState(resultState: ResultState) {
        when(resultState){
            is ResultState.LOADING -> {
                binding.forecastProgressBar.visibility = View.VISIBLE
            }
            is ResultState.SUCCESS -> {
                binding.forecastProgressBar.visibility = View.GONE
                weatherAdapter.setForecast(resultState.results.list)
            }
            is ResultState.ERROR -> {
                binding.forecastProgressBar.visibility = View.GONE
                AlertDialog.Builder(requireContext())
                    .setTitle("An Error Occurred")
                    .setMessage(resultState.error.localizedMessage)
                    .setPositiveButton("Dismiss") {dialogInterface, i ->
                        dialogInterface.dismiss()}
                    .create()
                    .show()
            }
        }
    }

    override fun onWeatherClicked(forecast: Forecast) {
        weatherViewModel.forecastChoice = forecast
        findNavController().navigate(R.id.action_ForecastFragment_to_DetailsFragment)
    }

    companion object {
        private const val WEATHER = " Forecast"
    }

}