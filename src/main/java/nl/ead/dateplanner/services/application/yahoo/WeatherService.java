package nl.ead.dateplanner.services.application.yahoo;

import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.aksingh.owmjapis.OpenWeatherMap.Units.METRIC;

public class WeatherService {

    private Byte days = 7;

    public WeatherData retrieveWeather(String city) throws IOException {
        OpenWeatherMap owm = new OpenWeatherMap(METRIC, "");
        DailyForecast dailyForecast = owm.dailyForecastByCityName(city, "NL", days);

        List<Forecast> forecasts = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            Forecast forecast = new Forecast();

            DailyForecast.Forecast currentForecast = dailyForecast.getForecastInstance(i);

            forecast.dayTemperature = currentForecast.getTemperatureInstance().getDayTemperature();
            forecast.eveningTemperature = currentForecast.getTemperatureInstance().getEveningTemperature();
            forecast.maximumTemperature = currentForecast.getTemperatureInstance().getMaximumTemperature();
            forecast.minimumTemperature = currentForecast.getTemperatureInstance().getMinimumTemperature();
            forecast.morningTemperature = currentForecast.getTemperatureInstance().getMorningTemperature();
            forecast.nightTemperature = currentForecast.getTemperatureInstance().getNightTemperature();

            forecasts.add(forecast);
        }

        WeatherData weatherData = new WeatherData();

        weatherData.setForecasts(forecasts);

        return weatherData;
    }
}