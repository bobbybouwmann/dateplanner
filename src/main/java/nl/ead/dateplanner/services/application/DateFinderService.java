package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.GeoLocation;
import nl.ead.dateplanner.services.application.google.IGeoLocationService;
import nl.ead.dateplanner.services.application.google.IPlacesService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;
import nl.ead.dateplanner.services.application.openweather.IWeatherService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Future;

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
            Future<List<Place>> places = getPlacesNearLocation(type, radius, longitude, latitude);
            Future<List<Forecast>> forecasts = getForecasts(dayPart, longitude, latitude);

            // Wait until we have the results from both calls
            while (!places.isDone() && !forecasts.isDone()) {
            }
            dateOption.places = places.get();
            dateOption.forecasts =  forecasts.get();
        } catch (Exception e) {
            // TODO handle exception
        }

        return dateOption;
    }

    @Async
    private Future<List<Forecast>> getForecasts(String dayPart, BigDecimal longitude, BigDecimal latitude) throws IOException {
        return new AsyncResult<>(weatherService.retrieveWeather(latitude, longitude, dayPart));
    }

    @Async
    private Future<List<Place>> getPlacesNearLocation(String type, BigDecimal radius, BigDecimal longitude, BigDecimal latitude) {
        return new AsyncResult<>(placesService.getPlacesNearLocation(latitude, longitude, type, radius));
    }

}