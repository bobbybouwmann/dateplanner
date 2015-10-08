package nl.ead.dateplanner.services.application;

import junit.framework.TestCase;
import nl.ead.dateplanner.services.application.google.*;
import nl.ead.dateplanner.services.application.openweather.Forecast;
import nl.ead.dateplanner.services.application.openweather.IWeatherService;
import nl.ead.dateplanner.services.application.openweather.TestWeatherService;
import org.junit.Assert;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateFinderServiceTest extends TestCase {

    TestWeatherService weatherService;
    TestPlacesService placesService;
    TestGeoLocationService geoLocationService;

    @Before
    public void setUp() throws Exception{
        weatherService = new TestWeatherService();
        placesService = new TestPlacesService();
        geoLocationService = new TestGeoLocationService();
    }

    public void testGetDateOptions() throws Exception {
        IDateFinderService service = GetDateFinderService();

        String type = "restaurant";
        String location = "arnhem";
        String dayPart = "morning";
        Double radius = 1000.0;
        placesService.SetReturnValue(GeneratePlaces(type, location, 10));
        weatherService.SetReturnValue(generateForecasts(7));
        geoLocationService.SetReturnValue(new GeoLocation(new BigDecimal(55.0), new BigDecimal(5.33)));

        List<DateOption> options = service.getDateOptions(type, location, dayPart, radius);

        Assert.assertEquals("Did not have the same amount of date options as places", 10, options.size());
    }

    private List<Forecast> generateForecasts(int amount) {
        List<Forecast> forecasts = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Forecast forecast = new Forecast();

            forecast.clouds = 1f;
            forecast.date = new Date();
            forecast.maximumTemperature = 16f;
            forecast.minimumTemperature = 12f;
            forecast.snow = 0f;
            forecast.temperature = 14f;
            forecast.rain = 1f;

            forecasts.add(forecast);
        }

        return forecasts;
    }

    private List<Place> GeneratePlaces(String type, String location, int amount) {
        List<Place> places = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            Place aPlace = new Place();
            aPlace.name = "place" + i;
            aPlace.placeId = aPlace.name;
            aPlace.type = type;
            aPlace.vicinity = aPlace.name + " near " + location;
            aPlace.longitude = 55.0;
            aPlace.latitude = 5.33;

            places.add(aPlace);
        }
        return places;
    }

    private DateFinderService GetDateFinderService() {
        return new DateFinderService(placesService, weatherService, geoLocationService);
    }
}