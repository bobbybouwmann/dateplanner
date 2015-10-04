package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.IPlacesService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.yahoo.IWeatherService;
import nl.ead.dateplanner.services.application.yahoo.WeatherData;

import java.io.IOException;
import java.util.List;

public class DateFinderService {

    public DateFinderService(IPlacesService placesService, IWeatherService weatherService) {
        this.placesService = placesService;
        this.weatherService = weatherService;
    }

    public String findWeather()
    {
//        WeatherService weatherService = new WeatherService(locationType);
//
//        return weatherService.generateQuery();
        return "";
    }


    public void getDateOptions(String type, String location) {
        List<Place> places = placesService.getPlacesNearLocation(type, location);
        try {
            WeatherData weatherForecasts = weatherService.retrieveWeather(location);
        } catch (IOException e) {
            // TODO handle exception
        }
    }

    private IPlacesService placesService;
    private IWeatherService weatherService;
}