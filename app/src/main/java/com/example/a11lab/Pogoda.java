package com.example.a11lab;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class Pogoda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pogoda);

        String cityName = getIntent().getStringExtra("CITY_NAME");

        WeatherData weatherData = getWeatherData(cityName);

        if (weatherData != null) {
            populateWeatherInfo(weatherData);
        } else {
            populateWeatherInfo(new WeatherData(
                    "Неизвестно", "Неизвестно", "Неизвестно", "Неизвестно",
                    "Неизвестно", "Неизвестно", "Неизвестно", R.drawable.unknown
            ));
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }

    private void populateWeatherInfo(WeatherData data) {
        ((TextView) findViewById(R.id.cityName)).setText(data.cityName);
        ((ImageView) findViewById(R.id.weatherIcon)).setImageResource(data.iconResId);
        ((TextView) findViewById(R.id.weatherDescription)).setText(data.description);
        ((TextView) findViewById(R.id.temperature)).setText(data.temperature);
        ((TextView) findViewById(R.id.feelsLike)).setText(data.feelsLike);
        ((TextView) findViewById(R.id.morningTemp)).setText(data.morningTemp);
        ((TextView) findViewById(R.id.dayTemp)).setText(data.dayTemp);
        ((TextView) findViewById(R.id.nightTemp)).setText(data.nightTemp);
    }

    private WeatherData getWeatherData(String cityName) {
        Map<String, WeatherData> weatherMap = new HashMap<>();
        weatherMap.put("Москва", new WeatherData(
                "Москва", "10°C", "ощущается как 8°C", "Утро: 4°C",
                "День: 10°C", "Ночь: 5°C", "Дождь", R.drawable.rainy
        ));
        weatherMap.put("Борисоглебск", new WeatherData(
                "Борисоглебск", "14°C", "ощущается как 16°C", "Утро: 8°C",
                "День: 13°C", "Ночь: 9°C", "Переменная облачность", R.drawable.partly_cloudy
        ));
        weatherMap.put("Волгоград", new WeatherData(
                "Волгоград", "6°C", "ощущается как 8°C", "Утро: 5°C",
                "День: 6°C", "Ночь: 3°C", "Ливни с грозами", R.drawable.thunderstorm
        ));
        weatherMap.put("Воронеж", new WeatherData(
                "Воронеж", "16°C", "ощущается как 14°C", "Утро: 12°C",
                "День: 15°C", "Ночь: 9°C", "Переменная облачность", R.drawable.partly_cloudy
        ));
        weatherMap.put("Тамбов", new WeatherData(
                "Тамбов", "15°C", "ощущается как 14°C", "Утро: 7°C",
                "День: 15°C", "Ночь: 9°C", "Облачно", R.drawable.cloudy
        ));
        weatherMap.put("Саратов", new WeatherData(
                "Саратов", "5°C", "ощущается как 8°C", "Утро: 2°C",
                "День: 5°C", "Ночь: 1°C", "Солнечно", R.drawable.sunny
        ));

        return weatherMap.get(cityName);
    }

    static class WeatherData {
        String cityName;
        String temperature;
        String feelsLike;
        String morningTemp;
        String dayTemp;
        String nightTemp;
        String description;
        int iconResId;

        WeatherData(String cityName, String temperature, String feelsLike, String morningTemp,
                    String dayTemp, String nightTemp, String description, int iconResId) {
            this.cityName = cityName;
            this.temperature = temperature;
            this.feelsLike = feelsLike;
            this.morningTemp = morningTemp;
            this.dayTemp = dayTemp;
            this.nightTemp = nightTemp;
            this.description = description;
            this.iconResId = iconResId;
        }
    }
}
