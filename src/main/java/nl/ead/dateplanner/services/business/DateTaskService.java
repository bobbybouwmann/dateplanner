package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.DateOptions;
import nl.ead.dateplanner.services.DatePlannerResponse;
import nl.ead.dateplanner.services.ForecastType;
import nl.ead.dateplanner.services.PlaceType;
import nl.ead.dateplanner.services.application.DateOption;
import nl.ead.dateplanner.services.application.IDateFinderService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateTaskService implements IDateTaskService {
    private final IDateFinderService dateFinder;

    public DateTaskService(IDateFinderService dateFinder) {
        this.dateFinder = dateFinder;
    }

    public DatePlannerResponse getDateOption(DateOptions options) throws IOException, DatatypeConfigurationException {
        List<DateOption> dateOptions = dateFinder.getDateOptions(options.getTypes().value(), options.getLocation(), options.getDayPart().value(), options.getRadius().doubleValue());

        List<PlaceType> placeTypes = this.getPlaceTypes(dateOptions);

        // TODO: Sort the "placeTypes" list here, return a list with options based on distance

        DatePlannerResponse response = new DatePlannerResponse();

        response.getPlaces().addAll(placeTypes);

        return response;
    }

    private List<PlaceType> getPlaceTypes(List<DateOption> dateOptions) throws DatatypeConfigurationException {
        List<PlaceType> places = new ArrayList<>();

        for (DateOption dateOption : dateOptions) {
            Forecast forecast = this.getBestForecast(dateOption.forecast);

            ForecastType forecastType = this.createForecastType(forecast);

            PlaceType placeType = this.createPlaceType(dateOption.place);

            placeType.setDate(this.setDate(forecast.date));

            placeType.setForecast(forecastType);

            places.add(placeType);
        }

        return places;
    }

    private Forecast getBestForecast(List<Forecast> forecasts) {
        Float highestTemperature = 0f;
        int index = 0;

        for (int i = 0; i < forecasts.size(); i++) {
            if (forecasts.get(i).temperature > highestTemperature) {
                highestTemperature = forecasts.get(i).temperature;
                index = i;
            }
        }

        return forecasts.get(index);
    }

    private ForecastType createForecastType(Forecast forecast) {
        ForecastType forecastType = new ForecastType();

        forecastType.setClouds(forecast.clouds);
        forecastType.setSnow(forecast.snow);
        forecastType.setMaxTemperature(forecast.maximumTemperature);
        forecastType.setMinTemperature(forecast.minimumTemperature);
        forecastType.setTemperature(forecast.temperature);

        return forecastType;
    }

    private PlaceType createPlaceType(Place place) {
        PlaceType placeType = new PlaceType();

        placeType.setName(place.name);
        placeType.setPlaceId(place.placeId);
        placeType.setLatitude(new BigDecimal(place.latitude));
        placeType.setLongitude(new BigDecimal(place.longitude));
        placeType.setOpeningHours(place.openingHours.toString());
        placeType.setType(place.type);
        placeType.setVicinity(place.vicinity);

        return placeType;
    }

    private XMLGregorianCalendar setDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    }

}
