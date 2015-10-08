package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDateFinderService implements IDateFinderService {

    @Override
    public List<DateOption> getDateOptions(String type, String location, String dayPart, Double radius) throws IOException {
        Forecast forecastOne = new Forecast();
        forecastOne.clouds = 0f;
        forecastOne.snow = 0f;
        forecastOne.rain = 0f;
        forecastOne.minimumTemperature = 0f;
        forecastOne.maximumTemperature = 0f;
        forecastOne.temperature = 0f;

        Forecast forecastTwo = new Forecast();
        forecastTwo.clouds = 0f;
        forecastTwo.snow = 0f;
        forecastTwo.rain = 0f;
        forecastTwo.minimumTemperature = 0f;
        forecastTwo.maximumTemperature = 0f;
        forecastTwo.temperature = 0f;

        Place place = new Place();
        place.latitude = 50.12;
        place.longitude = 45.99;
        place.name = "Dummy restaurant";
        place.placeId = "1234567890";
        place.type = "restaurant";
        place.vicinity = "Dummy Street 234, Colorado";
        place.openingHours = new ArrayList<>();

        DateOption dateOptionOne = new DateOption();
        DateOption dateOptionTwo = new DateOption();

        dateOptionOne.forecast.add(forecastOne);
        dateOptionOne.forecast.add(forecastTwo);

        dateOptionTwo.forecast.add(forecastOne);
        dateOptionTwo.forecast.add(forecastTwo);

        dateOptionOne.place = place;
        dateOptionTwo.place = place;

        List<DateOption> dateOptions = new ArrayList<>();

        dateOptions.add(dateOptionOne);
        dateOptions.add(dateOptionTwo);

        return dateOptions;
    }

}
