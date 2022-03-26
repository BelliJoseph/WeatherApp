package com.example.myweatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.model.Forecast
import com.example.myweatherapp.rest.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var userChoice: String? = null

    var forecastChoice: Forecast? = null

    private val _cityForecast: MutableLiveData<ResultState> = MutableLiveData(ResultState.LOADING)
    val cityForecast: LiveData<ResultState> get() = _cityForecast

    fun getForecast(city: String){
        viewModelScope.launch(ioDispatcher) {
            //worker thread
            try{
                val response = weatherRepository.getCityForecast(city)
                if(response.isSuccessful){
                    response.body()?.let{
                        //here I have forecast for the city
                        //_cityForecast.postValue(ResultState.SUCCESS(it))
                        withContext(Dispatchers.Main){
                            //this is the main thread
                            Log.d("***","Success")
                            _cityForecast.value = ResultState.SUCCESS(it)
                        }
                    }
                } else {
                    //handle error
                    Log.d("***","else statement")
                    throw java.lang.Exception("City name entered not Found")
                }
            }catch (e: Exception){
                //catch any errors
                    Log.d("***","Failure")
                _cityForecast.postValue(ResultState.ERROR(e))
            }



        }

    }
}