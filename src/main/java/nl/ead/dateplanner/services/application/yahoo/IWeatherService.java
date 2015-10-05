package nl.ead.dateplanner.services.application.yahoo;

import java.io.IOException;
import java.util.List;

public interface IWeatherService {

    List<Forecast> retrieveWeather(String countryCode, String city, String dayPart) throws IOException;

}
