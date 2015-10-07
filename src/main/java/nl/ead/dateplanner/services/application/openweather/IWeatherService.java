package nl.ead.dateplanner.services.application.openweather;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IWeatherService {

    List<Forecast> retrieveWeather(Float latitude, Float longitude, String dayPart) throws IOException;

}
