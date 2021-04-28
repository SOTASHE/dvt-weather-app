package com.snaye.dvtweatherapp.data
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.snaye.dvtweatherapp.BuildConfig
import com.snaye.dvtweatherapp.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//ee80c4c004fddb21766673237f73fd07
//http://api.openweathermap.org/data/2.5/weather?q=Durban&appid=ee80c4c004fddb21766673237f73fd07
const val  API_KEY ="ee80c4c004fddb21766673237f73fd07"

interface OpenWeatherApiService {
    @GET("/data/2.5/weather")
    fun  getCurrentWeatherAsync(
            @Query("q") city: String,
            @Query("appid") apiKey: String

    ): Deferred<CurrentWeatherResponse>

    companion object{
        operator fun  invoke():OpenWeatherApiService{
           val requestInterceptor = Interceptor{ chain ->
               val url = chain.request()
                   .url
                       .newBuilder()
                       .addQueryParameter("q", API_KEY)
                       .build()
               val request = chain.request()
                       .newBuilder()
                       .url(url)
                       .build()

               return@Interceptor chain.proceed(request)
               
           }





            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            //val builder = OkHttpClient.Builder()
            //if (BuildConfig.DEBUG) {
              //  builder.addInterceptor( OkHttpProfilerInterceptor() )
            //}

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://api.openweathermap.org")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(OpenWeatherApiService::class.java)



        }
    }
}

