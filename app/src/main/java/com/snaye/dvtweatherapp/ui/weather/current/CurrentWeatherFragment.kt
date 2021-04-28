package com.snaye.dvtweatherapp.ui.weather.current

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.snaye.dvtweatherapp.R
import com.snaye.dvtweatherapp.data.OpenWeatherApiService
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        val  apiService =  OpenWeatherApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val  currentWeatherResponse = apiService.getCurrentWeatherAsync("Durban", "ee80c4c004fddb21766673237f73fd07").await()
            texV.text = currentWeatherResponse.currentWeatherEntry.toString()
        }

    }
    }

