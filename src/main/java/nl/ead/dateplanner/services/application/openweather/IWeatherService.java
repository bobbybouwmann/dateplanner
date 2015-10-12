package nl.ead.dateplanner.services.application.openweather;

import java.io.IOException;
import java.util.List;

public interface IWeatherService {

    /**
     * Retrieve the weather based on the location (latitude, longitude).
     * Also set the temperature based on the day part.
     *
     * @param latitude Location latitude
     * @param longitude Location longitude
     * @param dayPart Day part for the forecast
     *
     * @return Return a list of forecasts.
     * @throws IOException
     */
    List<Forecast> retrieveWeather(Float latitude, Float longitude, String dayPart) throws IOException;

}
