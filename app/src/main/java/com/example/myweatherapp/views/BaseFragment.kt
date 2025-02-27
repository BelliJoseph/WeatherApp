package com.example.myweatherapp.views

import androidx.fragment.app.Fragment
import com.example.myweatherapp.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


open class BaseFragment: Fragment() {

    protected val weatherViewModel: WeatherViewModel by viewModel()
}