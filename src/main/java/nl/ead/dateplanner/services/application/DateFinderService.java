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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class DateFinderService implements IDateFinderService {

    /**
     * Create a DateFinderService
     * @param placesService Service to find places near coordinates
     * @param weatherService Service to find the forecasts near coordinates
     * @param locationService Service to convert name to coordinates
     */
    public DateFinderService(IPlacesService placesService, IWeatherService weatherService, IGeoLocationService locationService) {
        this.placesService = placesService;
        this.weatherService = weatherService;
        this.locationService = locationService;
    }

    /**
     * Get date options with places and forecasts
     * @param type The type of places
     * @param location The location where we want to search for places
     * @param dayPart What part of the day do we want to plan a date
     * @param radius How far away from the location do we want to find dates
     * @return Date options with places and forecasts. Empty list if nothing could be found
     * @throws IOException
     */
    public List<DateOption> getDateOptions(String type, String location, String dayPart, Double radius) throws IOException {
        // Find the coordinates for the location
        GeoLocation geoLocation = locationService.getLocation(location);
        Double longitude = geoLocation.longitude.doubleValue();
        Double latitude = geoLocation.latitude.doubleValue();

        // Get all places near the coordinates of the location
        List<Place> places = getPlacesNearLocation(latitude, longitude, type, radius);

        try {
            // We want to get the actual forecast for each returned place
            // We don't have to wait until a previous request for a forecast has arrived
            // So we do everything async
            List<Future<List<Forecast>>> asyncForecasts = new ArrayList<>();
            for (Place place : places) {
                Future<List<Forecast>> forecasts = getForecasts(place.latitude, place.longitude, dayPart);
                asyncForecasts.add(forecasts);
            }

            // Wait until we have received all forecasts
            while (!hasReceivedAllForecasts(asyncForecasts)) {}

            // Combine the places and forecasts into dateOptions
            List<DateOption> dateOptions = new ArrayList<>();
            for (int i = 0; i < places.size(); i++) {
                DateOption dateOption = new DateOption();
                dateOption.place = places.get(i);
                dateOption.forecast = asyncForecasts.get(i).get();
                dateOptions.add(dateOption);
            }
            return dateOptions;
        } catch (Exception e) {
            // TODO handle exception
        }
        return new ArrayList<>();
    }

    @Async
    private Future<List<Forecast>> getForecasts(Double latitude, Double longitude, String dayPart) throws IOException {
        return new AsyncResult<>(weatherService.retrieveWeather(latitude.floatValue(), longitude.floatValue(), dayPart));
    }

    private List<Place> getPlacesNearLocation(Double latitude, Double longitude, String type, Double radius) {
        return (placesService.getPlacesNearLocation(latitude, longitude, type, radius));
    }

    private Boolean hasReceivedAllForecasts(List<Future<List<Forecast>>> asyncForecasts) {
        for (Future<List<Forecast>> a : asyncForecasts) {
            if (!a.isDone()) {
                return false;
            }
        }
        return true;
    }


    private IPlacesService placesService;

    private IWeatherService weatherService;

    private IGeoLocationService locationService;

}