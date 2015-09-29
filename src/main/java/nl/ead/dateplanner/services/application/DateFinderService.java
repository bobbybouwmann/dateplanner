package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.yahoo.WeatherService;

public class DateFinderService {

    public String findWeather()
    {
        WeatherService weatherService = new WeatherService();

        return weatherService.WeatherService();
    }
	
}