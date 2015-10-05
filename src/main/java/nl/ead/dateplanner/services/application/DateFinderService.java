package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.IPlacesService;
import nl.ead.dateplanner.services.application.openweather.IWeatherService;

import java.io.IOException;

public class DateFinderService implements IDateFinderService {

    private IPlacesService placesService;
    private IWeatherService weatherService;

    public DateFinderService(IPlacesService placesService, IWeatherService weatherService) {
        this.placesService = placesService;
        this.weatherService = weatherService;
    }

    public DateOption getDateOptions(String type, String countryCode, String location, String dayPart) {
        DateOption dateOption = new DateOption();

        try {
            dateOption.places = placesService.getPlacesNearLocation(countryCode, type, location);
            dateOption.forecasts = weatherService.retrieveWeather(countryCode, location, dayPart);
        } catch (IOException e) {
            // TODO handle exception
        }

        return dateOption;
    }

}