package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.IPlacesService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.yahoo.IWeatherService;
import nl.ead.dateplanner.services.application.yahoo.WeatherData;

import java.io.IOException;
import java.util.List;

public class DateFinderService implements IDateFinderService {

    public DateFinderService(IPlacesService placesService, IWeatherService weatherService) {
        this.placesService = placesService;
        this.weatherService = weatherService;
    }

    public List<DateOption> getDateOptions(String type, String countryCode, String location, String dayPart) {
        List<Place> places = placesService.getPlacesNearLocation(countryCode, type, location);

        try {
            WeatherData weatherForecasts = weatherService.retrieveWeather(countryCode, location, dayPart);
        } catch (IOException e) {
            // TODO handle exception
        }

        return null;
    }

    private IPlacesService placesService;
    private IWeatherService weatherService;
}