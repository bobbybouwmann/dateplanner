package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.OpeningHour;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import java.io.IOException;
import java.math.BigDecimal;

public class TestDateFinderService implements IDateFinderService {

    @Override
    public DateOption getDateOptions(String type, String location, String dayPart, BigDecimal radius) throws IOException {
        DateOption dateOption = new DateOption();

        Forecast forecast = new Forecast();
        forecast.temperature = 0f;
        forecast.minimumTemperature = 0f;
        forecast.maximumTemperature = 0f;
        forecast.clouds = 0f;
        forecast.snow = true;
        forecast.rain = true;

        OpeningHour openingHour = new OpeningHour();
        openingHour.openDay = "Monday";
        openingHour.openHour = 0;
        openingHour.openMinute = 0;
        openingHour.closeDay = "Sunday";
        openingHour.closeHour = 0;
        openingHour.closeMinute = 0;

        Place place = new Place();
        place.name = "Dummy Cafe";
        place.openingHours.add(openingHour);
        place.placeId = "";
        place.type = type;
        place.vicinety = location;

        dateOption.forecasts.add(forecast);
        dateOption.places.add(place);

        return dateOption;
    }
}
