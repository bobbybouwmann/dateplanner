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
            List<Place> places = getPlacesNearLocation(latitude, longitude, type, radius);

            List<Future<List<Forecast>>> asyncForecasts = new ArrayList<>();
            for (Place place : places) {
                Future<List<Forecast>> forecasts = getForecasts(place.latitude, place.longitude, dayPart);
                asyncForecasts.add(forecasts);
            }

            Boolean isWaiting = true;
            while (isWaiting) {
                isWaiting = false;

                for (Future<List<Forecast>> a : asyncForecasts) {
                    if (!a.isDone()) {
                        isWaiting = true;
                    }
                }
            }

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

}