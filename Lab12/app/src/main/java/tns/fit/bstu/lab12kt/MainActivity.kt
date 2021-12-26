package tns.fit.bstu.lab12kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private var weatherData: TextView? = null
    private var latitude: TextView? = null
    private var longitude: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherData = findViewById(R.id.textView)
        findViewById<View>(R.id.button).setOnClickListener { getCurrentData() }
    }

    internal fun getCurrentData() {
        latitude = findViewById(R.id.latitide)
        longitude = findViewById(R.id.longitude)
        weatherData!!.text = ""

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(WeatherService::class.java)
        val call = service.getCurrentWeatherData(latitude!!.text.toString(), longitude!!.text.toString(), AppId)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = "Country: " +
                            weatherResponse.sys!!.country +
                            "\n" +
                            "Temperature: " +
                            (weatherResponse.main!!.temp - 273) +
                            " C\n" +
                            "Temperature(Min): " +
                            (weatherResponse.main!!.temp_min - 273) +
                            " C\n" +
                            "Temperature(Max): " +
                            (weatherResponse.main!!.temp_max - 273) +
                            " C\n" +
                            "Humidity: " +
                            weatherResponse.main!!.humidity +
                            " Perc\n" +
                            "Pressure: " +
                            weatherResponse.main!!.pressure / 10 +
                            " KPa \n" +
                            "wind speed: " +
                            weatherResponse.wind!!.speed  +
                            " m/s \n" +
                            "wind angle: " +
                            weatherResponse.wind!!.deg  +
                            " deg \n" +
                            "Sunrise: " +
                            weatherResponse.sys!!.getDateTime(weatherResponse.sys!!.sunrise.toString()) +
                            "\n" +
                            "Sunset: " +
                            weatherResponse.sys!!.getDateTime(weatherResponse.sys!!.sunset.toString())

                    weatherData!!.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }
        })
    }

    companion object {

        var BaseUrl = "http://api.openweathermap.org/"
        var AppId = "2e65127e909e178d0af311a81f39948c"
        var lat = "35"
        var lon = "139"
    }


}