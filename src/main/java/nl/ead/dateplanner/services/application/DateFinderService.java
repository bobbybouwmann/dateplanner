package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.GeoLocation;
import nl.ead.dateplanner.services.application.google.IGeoLocationService;
import nl.ead.dateplanner.services.application.google.IPlacesService;
import nl.ead.dateplanner.services.application.openweather.IWeatherService;

import java.io.IOException;
import java.math.BigDecimal;

public class DateFinderService implements IDateFinderService {

    private IPlacesService placesService;
    private IWeatherService weatherService;
    private IGeoLocationService locationService;

    public DateFinderService(IPlacesService placesService, IWeatherService weatherService, IGeoLocationService locationService) {
        this.placesService = placesService;
        this.weatherService = weatherService;
        this.locationService = locationService;
    }

    public DateOption getDateOptions(String type, String location, String dayPart, BigDecimal radius) throws IOException {
        DateOption dateOption = new DateOption();

        // Find the coordinates for the location
        GeoLocation geoLocation = locationService.getLocation(location);
        BigDecimal longitude = geoLocation.longitude;
        BigDecimal latitude = geoLocation.latitude;

        try {
            dateOption.places = placesService.getPlacesNearLocation(latitude, longitude, type, radius);
            dateOption.forecasts = weatherService.retrieveWeather(latitude, longitude, dayPart);
        } catch (IOException e) {
            // TODO handle exception
        }

        return dateOption;
    }

}