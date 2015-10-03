package nl.ead.dateplanner.services.application.yahoo;

import java.io.IOException;

/**
 * Created by thoma on 3-10-2015.
 */
public interface IWeatherService {

    public WeatherData retrieveWeather(String city) throws IOException;
}
