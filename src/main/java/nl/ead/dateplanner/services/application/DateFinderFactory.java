package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.GeoLocationService;
import nl.ead.dateplanner.services.application.google.PlacesService;
import nl.ead.dateplanner.services.application.openweather.WeatherService;

public class DateFinderFactory {

    public IDateFinderService create() {
        return new DateFinderService(new PlacesService(), new WeatherService(), new GeoLocationService());
    }

}
