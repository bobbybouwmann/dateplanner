package nl.ead.dateplanner.services.business;

import junit.framework.TestCase;
import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.DateOption;
import nl.ead.dateplanner.services.application.TestDateFinderService;;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;
import org.junit.Before;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DateTaskServiceTest extends TestCase {

    private DateTaskService dateTaskService;

    @Before
    public void setUp() throws Exception{
        dateTaskService = new DateTaskService(new TestDateFinderService());
    }

    public void testDateTaskServiceImplementsInterface() throws Exception {
        assertThat(dateTaskService, instanceOf(IDateTaskService.class));
    }

    public void testGetDateOption() throws Exception {
        String type = "restaurant";

        DateOptions dateOptions = new DateOptions();
        dateOptions.setDayPart(DayParts.fromValue("evening"));
        dateOptions.setLocation("Dummy Street 234, Colorado");
        dateOptions.setRadius(new BigDecimal(20000));
        dateOptions.setTypes(PlaceTypes.fromValue(type));

        DatePlannerResponse datePlannerResponse = dateTaskService.getDateOption(dateOptions);

        assertEquals(datePlannerResponse.getPlaces().size(), 2);
        assertEquals(datePlannerResponse.getPlaces().get(0).getType(), type);
    }

    public void testGetPlaceTypes() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int amount = 5;

        List<DateOption> dateOptions = generateTestDateOptions(amount);

        Method method = dateTaskService.getClass().getDeclaredMethod("getPlaceTypes", List.class);
        method.setAccessible(true);

        List<PlaceType> result = (List<PlaceType>) method.invoke(dateTaskService, dateOptions);

        assertEquals(result.size(), amount);
        assertEquals(result.get(0).getName(), "Dummy");
    }

    public void testGetBestForecast() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Forecast> forecasts = generateTestForecasts(7);

        Forecast bestForecast = genereateBestForecast();

        forecasts.add(4, bestForecast);

        Method method = dateTaskService.getClass().getDeclaredMethod("getBestForecast", List.class);
        method.setAccessible(true);

        Forecast forecast = (Forecast) method.invoke(dateTaskService, forecasts);

        assertEquals(forecast.maximumTemperature, bestForecast.maximumTemperature);
        assertEquals(forecast.minimumTemperature, bestForecast.minimumTemperature);
        assertEquals(forecast.temperature, bestForecast.temperature);
    }

    public void testCreateForecastType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Forecast> forecasts = generateTestForecasts(1);

        Forecast forecast = forecasts.get(0);

        Method method = dateTaskService.getClass().getDeclaredMethod("createForecastType", Forecast.class);
        method.setAccessible(true);

        ForecastType forecastType = (ForecastType) method.invoke(dateTaskService, forecast);

        assertEquals(forecastType.getClouds(), forecast.clouds);
        assertEquals(forecastType.getMaxTemperature(), forecast.maximumTemperature);
        assertEquals(forecastType.getMinTemperature(), forecast.minimumTemperature);
        assertEquals(forecastType.getRain(), forecast.rain);
        assertEquals(forecastType.getSnow(), forecast.snow);
        assertEquals(forecastType.getTemperature(), forecast.temperature);
    }

    public void testCreatePlaceType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Place place = generateTestPlace();

        Method method = dateTaskService.getClass().getDeclaredMethod("createPlaceType", Place.class);
        method.setAccessible(true);

        PlaceType placeType = (PlaceType) method.invoke(dateTaskService, place);

        assertEquals(placeType.getLatitude().doubleValue(), place.latitude);
        assertEquals(placeType.getLongitude().doubleValue(), place.longitude);
        assertEquals(placeType.getName(), place.name);
        assertEquals(placeType.getOpeningHours(), place.openingHours.toString());
        assertEquals(placeType.getPlaceId(), place.placeId);
        assertEquals(placeType.getType(), place.type);
        assertEquals(placeType.getVicinity(), place.vicinity);
    }

    public void testSetDate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Date date = new Date();

        Method method = dateTaskService.getClass().getDeclaredMethod("setDate", Date.class);
        method.setAccessible(true);

        XMLGregorianCalendar xmlGregorianCalendar = (XMLGregorianCalendar) method.invoke(dateTaskService, date);

        assertEquals(xmlGregorianCalendar.getHour(), date.getHours());
        assertEquals(xmlGregorianCalendar.getMinute(), date.getMinutes());
        assertEquals(xmlGregorianCalendar.getSecond(), date.getSeconds());
    }

    private List<DateOption> generateTestDateOptions(int amount) {
        List<DateOption> dateOptions = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            DateOption dateOption = new DateOption();

            dateOption.place = generateTestPlace();
            dateOption.forecast.addAll(generateTestForecasts(7));

            dateOptions.add(dateOption);
        }

        return dateOptions;
    }

    private List<Forecast> generateTestForecasts(int amount) {
        List<Forecast> forecasts = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Forecast forecast = new Forecast();
            forecast.clouds = 0f;
            forecast.snow = 0f;
            forecast.rain = 0f;
            forecast.temperature = 0f;
            forecast.maximumTemperature = 0f;
            forecast.minimumTemperature = 0f;
            forecast.date = new Date();

            forecasts.add(forecast);
        }

        return forecasts;
    }

    private Forecast genereateBestForecast() {
        Forecast forecast = new Forecast();
        forecast.clouds = 0f;
        forecast.snow = 0f;
        forecast.rain = 0f;
        forecast.temperature = 110f;
        forecast.maximumTemperature = 120f;
        forecast.minimumTemperature = 80f;
        forecast.date = new Date();

        return forecast;
    }

    private Place generateTestPlace() {
        Place place = new Place();
        place.latitude = 52.99;
        place.longitude = 58.12;
        place.name = "Dummy";
        place.placeId = "1234567890";
        place.type = "restaurant";
        place.vicinity= "Dummy Street";

        return place;
    }

}