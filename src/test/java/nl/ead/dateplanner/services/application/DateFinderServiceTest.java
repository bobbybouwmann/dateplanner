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
import java.util.Objects;

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

    public void testGetDateOptions_places_amount() throws Exception {
        IDateFinderService service = GetDateFinderService();

        // Set up the return value of the api services
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

    public void testGetDateOptions_places_types() throws Exception {
        IDateFinderService service = GetDateFinderService();

        // Set up the return value of the api services
        String type = "restaurant";
        String location = "arnhem";
        String dayPart = "morning";
        Double radius = 1000.0;
        placesService.SetReturnValue(GeneratePlaces(type, location, 10));
        weatherService.SetReturnValue(generateForecasts(7));
        geoLocationService.SetReturnValue(new GeoLocation(new BigDecimal(55.0), new BigDecimal(5.33)));

        List<DateOption> options = service.getDateOptions(type, location, dayPart, radius);
        for (DateOption option : options) {
            Assert.assertEquals("Place type is not correct", type, option.place.type);
        }
    }

    public void testGetDateOptions_places_all_different() throws Exception {
        IDateFinderService service = GetDateFinderService();

        // Set up the return value of the api services
        String type = "restaurant";
        String location = "arnhem";
        String dayPart = "morning";
        Double radius = 1000.0;
        placesService.SetReturnValue(GeneratePlaces(type, location, 10));
        weatherService.SetReturnValue(generateForecasts(7));
        geoLocationService.SetReturnValue(new GeoLocation(new BigDecimal(55.0), new BigDecimal(5.33)));

        List<DateOption> options = service.getDateOptions(type, location, dayPart, radius);
        for (DateOption option : options) {
            Place placetoCheck = option.place;
            for (DateOption optionToCheck : options) {
                if (!option.equals(optionToCheck)) {
                    Assert.assertNotEquals("Place Id is a duplicate of " + placetoCheck.placeId, placetoCheck.placeId, optionToCheck.place.placeId);
                    // Check location is different - places should not be on the same coordinates
                    // Places may have the same name but should not be the on the same location
                    if (Objects.equals(placetoCheck.name, optionToCheck.place.name)) {
                        Assert.assertFalse(placetoCheck.longitude == optionToCheck.place.longitude && placetoCheck.latitude == optionToCheck.place.latitude);
                    }
                }
            }
        }
    }

    public void testGetDateOptions_all_places_have_forecast_list() throws Exception {
        IDateFinderService service = GetDateFinderService();

        // Set up the return value of the api services
        String type = "restaurant";
        String location = "arnhem";
        String dayPart = "morning";
        Double radius = 1000.0;
        placesService.SetReturnValue(GeneratePlaces(type, location, 10));
        weatherService.SetReturnValue(generateForecasts(7));
        geoLocationService.SetReturnValue(new GeoLocation(new BigDecimal(55.0), new BigDecimal(5.33)));

        List<DateOption> options = service.getDateOptions(type, location, dayPart, radius);
        for (DateOption option : options) {
            Assert.assertNotNull("Place type is not correct", option.forecast);
        }
    }
    public void testGetDateOptions_all_places_have_forecast_list_populated() throws Exception {
        IDateFinderService service = GetDateFinderService();

        // Set up the return value of the api services
        String type = "restaurant";
        String location = "arnhem";
        String dayPart = "morning";
        Double radius = 1000.0;
        placesService.SetReturnValue(GeneratePlaces(type, location, 10));
        weatherService.SetReturnValue(generateForecasts(7));
        geoLocationService.SetReturnValue(new GeoLocation(new BigDecimal(55.0), new BigDecimal(5.33)));

        List<DateOption> options = service.getDateOptions(type, location, dayPart, radius);
        for (DateOption option : options) {
            Assert.assertTrue("Place type is not correct", option.forecast.size() > 0);
        }
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
            aPlace.longitude = 55.0 + i/100;
            aPlace.latitude = 5.33 + i/100;

            places.add(aPlace);
        }
        return places;
    }

    private DateFinderService GetDateFinderService() {
        return new DateFinderService(placesService, weatherService, geoLocationService);
    }
}