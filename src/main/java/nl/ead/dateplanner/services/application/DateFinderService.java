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
import java.util.ArrayList;
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

    public List<DateOption> getDateOptions(String type, String location, String dayPart, Double radius) throws IOException {
        // Find the coordinates for the location
        GeoLocation geoLocation = locationService.getLocation(location);
        Double longitude = geoLocation.longitude.doubleValue();
        Double latitude = geoLocation.latitude.doubleValue();

        try {
            List<Place> places = getPlacesNearLocation(type, radius, longitude, latitude);

            List<Future<List<Forecast>>> forecastsAsyncs = new ArrayList<>();
            for (Place place : places ) {
                Future<List<Forecast>> forecasts = getForecasts(dayPart, place.longitude, place.latitude);
                forecastsAsyncs.add(forecasts);
            }

            Boolean isWaiting = true;
            while (isWaiting) {
                isWaiting = false;

                for (Future<List<Forecast>> a : forecastsAsyncs) {
                    if (!a.isDone()) {
                        isWaiting = true;
                    }
                }
            }

            List<DateOption> optionsDate = new ArrayList<>();
            for (int i = 0; i < places.size(); i++) {
                DateOption opt = new DateOption();
                opt.place = places.get(i);
                opt.forecast = forecastsAsyncs.get(i).get();
            }

            return optionsDate;
        } catch (Exception e) {
            // TODO handle exception
        }

        return new ArrayList<>();
    }

    @Async
    private Future<List<Forecast>> getForecasts(String dayPart, Double longitude, Double latitude) throws IOException {
        return new AsyncResult<>(weatherService.retrieveWeather(latitude.floatValue(), longitude.floatValue(), dayPart));
    }

    private List<Place> getPlacesNearLocation(String type, Double radius, Double longitude, Double latitude) {
        return (placesService.getPlacesNearLocation(latitude, longitude, type, radius));
    }

}