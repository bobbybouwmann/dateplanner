package nl.ead.dateplanner.services.application.yahoo;

import java.io.IOException;

public interface IWeatherService {

    WeatherData retrieveWeather(String countryCode, String city, String dayPart) throws IOException;

}