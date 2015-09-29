package nl.ead.dateplanner.services.application.yahoo;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;

public class WeatherService {

    public String WeatherService() {
        Channel channel = null;

        try {
            YahooWeatherService service = new YahooWeatherService();

            channel = service.getForecast("2502265", DegreeUnit.CELSIUS);
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return channel.getDescription();
    }
	
}