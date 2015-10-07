package nl.ead.dateplanner.services.business;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.DateOption;
import nl.ead.dateplanner.services.application.IDateFinderService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DateTaskService implements IDateTaskService {
    private final IDateFinderService dateFinder;

    public DateTaskService(IDateFinderService dateFinder) {
        this.dateFinder = dateFinder;
    }

    public DatePlannerResponse getDateOption(DateOptions options) throws IOException {
        List<DateOption> dateOptions = dateFinder.getDateOptions(options.getTypes().value(), options.getLocation(), options.getDayPart().value(), options.getRadius().doubleValue());
        DatePlannerResponse response = new DatePlannerResponse();

        // TODO: return a list with options based on distance

        for (int i = 0; i < dateOptions.size(); i++) {
            DateOption dateOption = dateOptions.get(i);

            Forecast forecast = this.getBestForecast(dateOption.forecast);

            ForecastType forecastType = this.createForecastType(forecast);

            PlaceType placeType = this.createPlaceType(dateOption.place);

            // TODO: Date is based on the selected weather day (dateTime of forecast)
            placeType.setDate(new XMLGregorianCalendarImpl());

            placeType.setForecast(forecastType);

            response.getPlaces().add(placeType);
        }

        return response;
    }

    private PlaceType createPlaceType(Place place) {
        PlaceType placeType = new PlaceType();

        placeType.setName(place.name);
        placeType.setPlaceId(place.placeId);
        placeType.setLatitude(new BigDecimal(place.latitude));
        placeType.setLongitude(new BigDecimal(place.longitude));
        placeType.setOpeningHours(place.openingHours.toString());
        placeType.setType(place.type);
        placeType.setVicinity(place.vicinety);

        return placeType;
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

    private Forecast getBestForecast(List<Forecast> forecasts) {
        Float highestTemperature = 0f;
        int index = 0;

        for(int i = 0; i < forecasts.size(); i++) {
            if (forecasts.get(i).temperature > highestTemperature) {
                highestTemperature = forecasts.get(i).temperature;
                index = i;
            }
        }

        return forecasts.get(index);
    }
}
