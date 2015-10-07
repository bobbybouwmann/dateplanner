package nl.ead.dateplanner.services.business;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.DateOption;
import nl.ead.dateplanner.services.application.IDateFinderService;
import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class DateTaskService implements IDateTaskService {
    private final IDateFinderService dateFinder;

    public DateTaskService(IDateFinderService dateFinder) {
        this.dateFinder = dateFinder;
    }

    public DatePlannerResponse getDateOption(DateOptions options) throws IOException {
        List<DateOption> dateOptions = dateFinder.getDateOptions(options.getTypes().value(), options.getLocation(), options.getDayPart().value(), options.getRadius().doubleValue());
        DatePlannerResponse response = new DatePlannerResponse();

        for (int i = 0; i < dateOptions.size(); i++) {
            DateOption dateOption = dateOptions.get(i);

            PlaceType placeType = new PlaceType();
            placeType.setName(dateOption.place.name);
            placeType.setPlaceId(dateOption.place.placeId);
            placeType.setLatitude(new BigDecimal(dateOption.place.latitude));
            placeType.setLongitude(new BigDecimal(dateOption.place.longitude));
            placeType.setOpeningHours(dateOption.place.openingHours.toString());
            placeType.setType(dateOption.place.type);
            placeType.setVicinity(dateOption.place.vicinety);
            placeType.setDate(new XMLGregorianCalendarImpl());

            ForecastType forecastType = new ForecastType();
            forecastType.setClouds(dateOption.forecast.get(0).clouds);
            forecastType.setSnow(dateOption.forecast.get(0).snow);
            forecastType.setMaxTemperature(dateOption.forecast.get(0).maximumTemperature);
            forecastType.setMinTemperature(dateOption.forecast.get(0).minimumTemperature);
            forecastType.setTemperature(dateOption.forecast.get(0).temperature);

            placeType.setForecast(forecastType);

            response.getPlaces().add(placeType);
        }

        return response;
    }
}
