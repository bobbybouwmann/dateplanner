package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.ForecastType;
import nl.ead.dateplanner.services.WeatherDataType;
import nl.ead.dateplanner.services.application.yahoo.Forecast;
import nl.ead.dateplanner.services.application.yahoo.IWeatherService;
import nl.ead.dateplanner.services.application.yahoo.WeatherData;

import java.io.IOException;
import java.util.List;

public class DateTaskService implements IDateTaskService {

    private final IWeatherService weatherService;

    public DateTaskService(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public WeatherDataType retrieveWeather(String location, String dayPart) throws IOException {
        WeatherData weatherData = this.weatherService.retrieveWeather(location, dayPart);

        List<Forecast> forecasts = weatherData.getForecasts();

        WeatherDataType weatherDataType = new WeatherDataType();

        for (int i = 0; i < forecasts.size(); i++) {
            ForecastType forecastType = new ForecastType();

            forecastType.setTemperature(forecasts.get(i).temperature);
            forecastType.setMaxTemperature(forecasts.get(i).maximumTemperature);
            forecastType.setMinTemperature(forecasts.get(i).minimumTemperature);
            forecastType.setSnow(forecasts.get(i).snow);
            forecastType.setRain(forecasts.get(i).rain);
            forecastType.setClouds(forecasts.get(i).clouds);

            weatherDataType.getForecast().add(forecastType);
        }

        return weatherDataType;
    }
}