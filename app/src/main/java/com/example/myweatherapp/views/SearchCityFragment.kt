package com.example.myweatherapp.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myweatherapp.MainActivity
import com.example.myweatherapp.R
import com.example.myweatherapp.databinding.FragmentSearchCityBinding



class SearchCityFragment : Fragment() {

    private val binding by lazy{
        FragmentSearchCityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.searchConfirmButton.setOnClickListener{
            val choice = binding.enterCityEdit.text
            (activity as MainActivity).userChoice = choice.toString()
            findNavController().navigate(R.id.action_SearchFragment_to_ForecastFragment)
        }


        // Inflate the layout for this fragment
        return binding.root
    }




    companion object {
        fun newInstance(param1: String, param2: String) =
            SearchCityFragment().apply {
                arguments = Bundle().apply {}
            }
    }

}