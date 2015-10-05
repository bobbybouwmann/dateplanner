package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.PlacesService;
import nl.ead.dateplanner.services.application.yahoo.WeatherService;

/**
 * Created by thoma on 5-10-2015.
 */
public class DateFinderFactory {

    public IDateFinderService create() {
        return new DateFinderService(new PlacesService(), new WeatherService());
    }
}
