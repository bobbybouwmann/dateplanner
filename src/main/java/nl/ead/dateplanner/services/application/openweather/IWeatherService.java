package nl.ead.dateplanner.services.application.openweather;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IWeatherService {

    List<Forecast> retrieveWeather(BigDecimal latitude, BigDecimal longitude, String dayPart) throws IOException;

}
