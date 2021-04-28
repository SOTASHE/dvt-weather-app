package com.snaye.dvtweatherapp.data.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
        val coord: Coord,
        val weather: List<Weather>,
        val base: String,
        @SerializedName("main")
    val currentWeatherEntry: CurrentWeatherEntry,
        val visibility: Int,
        val wind: Wind,
        val clouds: Clouds,
        val dt: Int,
        val sys: Sys,
        val timezone: Int,
        val id: Int,
        val name: String,
        val cod: Int
)