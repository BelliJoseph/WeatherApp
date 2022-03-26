package com.example.myweatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherapp.R
import com.example.myweatherapp.databinding.ForecastItemBinding
import com.example.myweatherapp.model.Forecast
import com.example.myweatherapp.model.Main
import com.example.myweatherapp.model.Weather

class WeatherAdapter(
    private val weatherClickListener: WeatherClickListener,
    private val forecastList: MutableList<Forecast> = mutableListOf()
) : RecyclerView.Adapter<ForecastViewHolder>() {

    fun setForecast(newForecast: List<Forecast>){
        forecastList.clear()
        forecastList.addAll(newForecast)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int){
        val forecastItem = forecastList[position]

        holder.itemView.setOnClickListener(){
            weatherClickListener.onWeatherClicked(forecastItem)
        }

        holder.bind(forecastItem)
    }


    override fun getItemCount(): Int = forecastList.size


}

class ForecastViewHolder(
    forecastView: View
    ): RecyclerView.ViewHolder(forecastView){

        private val temperature: TextView = forecastView.findViewById(R.id.weatherTemp)
        private val timeStamp: TextView = forecastView.findViewById(R.id.timeStamp)

        fun bind(forecast: Forecast){


            val temp = forecast.main.temp.convertKelvinToFahrenheit()
            val temp1 = temp.formatDecimal() + "\u2109"
            temperature.text = temp1
            timeStamp.text = forecast.dtTxt

        }



    }