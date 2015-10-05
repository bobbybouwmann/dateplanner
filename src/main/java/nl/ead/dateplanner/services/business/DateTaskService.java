package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.DateOption;
import nl.ead.dateplanner.services.application.IDateFinderService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.yahoo.Forecast;

public class DateTaskService implements IDateTaskService {
    private final IDateFinderService dateFinder;

    public DateTaskService(IDateFinderService dateFinder) {
        this.dateFinder = dateFinder;
    }

    public DatePlannerResponse getDateOption(DateOptions options) {
        DateOption dateOption = dateFinder.getDateOptions(options.getTypes().value(), options.getCountryCode(), options.getLocation(), options.getDayPart().value());
        DatePlannerResponse response = new DatePlannerResponse();

        DateDataType value = new DateDataType();
        value.setPlacesData(getPlacesDataType(dateOption));
        value.setWeatherData(getWeatherDataType(dateOption));

        response.setResult(value);

        return response;
    }

    private PlaceDataType getPlacesDataType(DateOption dateOption) {
        PlaceDataType placeDataType = new PlaceDataType();

        for (Place place : dateOption.places) {
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

    private WeatherDataType getWeatherDataType(DateOption dateOption) {
        WeatherDataType weatherDataType = new WeatherDataType();

        for (int i = 0; i < dateOption.forecasts.size(); i++) {
            Forecast forecast = dateOption.forecasts.get(i);
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
