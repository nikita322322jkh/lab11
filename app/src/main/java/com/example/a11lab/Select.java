package com.example.a11lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Map<Integer, String> buttonCityMap = new HashMap<>();
        buttonCityMap.put(R.id.buttonMoscow, "Москва");
        buttonCityMap.put(R.id.buttonBorisoglebsk, "Борисоглебск");
        buttonCityMap.put(R.id.buttonVolgograd, "Волгоград");
        buttonCityMap.put(R.id.buttonVoronezh, "Воронеж");
        buttonCityMap.put(R.id.buttonTambov, "Тамбов");
        buttonCityMap.put(R.id.buttonSaratov, "Саратов");

        for (Map.Entry<Integer, String> entry : buttonCityMap.entrySet()) {
            findViewById(entry.getKey()).setOnClickListener(view -> openWeatherActivity(entry.getValue()));
        }
    }

    private void openWeatherActivity(String city) {
        Intent intent = new Intent(this, Pogoda.class);
        intent.putExtra("CITY_NAME", city);
        startActivity(intent);
    }
}
