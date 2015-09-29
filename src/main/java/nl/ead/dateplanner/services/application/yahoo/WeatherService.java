package nl.ead.dateplanner.services.application.yahoo;

import nl.ead.dateplanner.services.LocationType;
import nl.ead.dateplanner.services.WeatherDataType;

public class WeatherService {

    private String weatherAPIUrl = "https://query.yahooapis.com/v1/public/yql?q=";

    private String query = "";

    private String result;

    public WeatherDataType retrieveWeather(LocationType locationType) {
        WeatherDataType weatherDataType = new WeatherDataType();

        result = "";

//        weatherDataType.setAstronomy();
//        weatherDataType.setForecast();
//        weatherDataType.setLocation();

        return weatherDataType;
    }

    public String generateQuery() {
        return "";
//        return this.locationType.getCity();
    }

    // new StringBuilder(this.weatherAPIUrl);
}