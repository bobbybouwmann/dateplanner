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
import java.util.*;

public class DateTaskService implements IDateTaskService {

    private final IDateFinderService dateFinder;

    public DateTaskService(IDateFinderService dateFinder) {
        this.dateFinder = dateFinder;
    }

    /**
     * Get the date options. A date option holds a place with a forecast.
     *
     * @param options The options from the request.
     *
     * @return Return a list of date options.
     *
     * @throws IOException
     * @throws DatatypeConfigurationException
     */
    public DatePlannerResponse getDateOption(DateOptions options) throws IOException, DatatypeConfigurationException {
        List<DateOption> dateOptions = dateFinder.getDateOptions(options.getTypes().value(), options.getLocation(), options.getDayPart().value(), options.getRadius().doubleValue());

        List<PlaceType> placeTypes = this.getPlaceTypes(dateOptions);

        // Sort by highest temperature
        Collections.sort(placeTypes, new Comparator<PlaceType>() {
            @Override
            public int compare(PlaceType lhs, PlaceType rhs) {
                return Float.compare(rhs.getForecast().getTemperature(), lhs.getForecast().getTemperature());
            }
        });

        DatePlannerResponse response = new DatePlannerResponse();

        for (int i = 0; i < placeTypes.size() && i < 20; i++) {
            try {
                response.getPlaces().add(placeTypes.get(i));
            } catch (Exception e) {
                // Ignore
            }
        }

        return response;
    }

    /**
     * Get all the places types based on the options.
     *
     * @param dateOptions The options from the request.
     *
     * @return A list of place types.
     * @throws DatatypeConfigurationException
     */
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

    /**
     * Get the best forecast based on the highest temperature.
     *
     * @param forecasts List of forecasts.
     *
     * @return The best forecast.
     */
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

    /**
     * Create a ForecastType object.
     *
     * @param forecast Forecast object.
     *
     * @return ForecastType object.
     */
    private ForecastType createForecastType(Forecast forecast) {
        ForecastType forecastType = new ForecastType();

        forecastType.setClouds(forecast.clouds);
        forecastType.setSnow(forecast.snow);
        forecastType.setMaxTemperature(forecast.maximumTemperature);
        forecastType.setMinTemperature(forecast.minimumTemperature);
        forecastType.setTemperature(forecast.temperature);

        return forecastType;
    }

    /**
     * Create a PlaceType object.
     *
     * @param place Place object.
     *
     * @return PlaceType object.
     */
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

    /**
     * Set the XMLGregorianCalendar date based on a date.
     *
     * @param date Date object.
     *
     * @return XMLGregorianCalendar object.
     * @throws DatatypeConfigurationException
     */
    private XMLGregorianCalendar setDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    }

}
