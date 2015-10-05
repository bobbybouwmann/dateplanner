package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.DateOption;
import nl.ead.dateplanner.services.application.IDateFinderService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import java.util.List;

public class DateTaskService implements IDateTaskService {
    private final IDateFinderService dateFinder;

    public DateTaskService(IDateFinderService dateFinder) {
        this.dateFinder = dateFinder;
    }

    public DatePlannerResponse getDateOption(DateOptions options) {
        DateOption dateOption = dateFinder.getDateOptions(options.getTypes().value(), options.getCountryCode(), options.getLocation(), options.getDayPart().value());
        DatePlannerResponse response = new DatePlannerResponse();

        DateDataType value = new DateDataType();
        value.setPlacesData(getPlacesDataType(dateOption.places));
        value.setWeatherData(getWeatherDataType(dateOption.forecasts));

        response.setResult(value);

        return response;
    }

    private PlaceDataType getPlacesDataType(List<Place> places) {
        PlaceDataType placeDataType = new PlaceDataType();

        for (Place place : places) {
            PlaceType placeType = new PlaceType();
            placeType.setId("");
            placeType.setName(place.name);
            placeType.setPlaceId(place.placeId);
            placeType.setType(place.type);
            placeType.setVicinity(place.vicinety);

            placeDataType.getPlaces().add(placeType);
        }

        return placeDataType;
    }

    private WeatherDataType getWeatherDataType(List<Forecast> forecasts) {
        WeatherDataType weatherDataType = new WeatherDataType();

        for (Forecast forecast : forecasts) {
            ForecastType forecastType = new ForecastType();
            forecastType.setClouds(forecast.clouds);
            forecastType.setMaxTemperature(forecast.maximumTemperature);
            forecastType.setMinTemperature(forecast.minimumTemperature);
            forecastType.setRain(forecast.rain);
            forecastType.setSnow(forecast.snow);
            forecastType.setTemperature(forecast.temperature);

            weatherDataType.getForecast().add(forecastType);
        }
        return weatherDataType;
    }
}
