package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.ForecastType;
import nl.ead.dateplanner.services.PlaceType;
import nl.ead.dateplanner.services.DateOptions;
import nl.ead.dateplanner.services.DatePlannerResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class TestDateTaskService implements IDateTaskService {

    @Override
    public DatePlannerResponse getDateOption(DateOptions options) throws IOException, DatatypeConfigurationException {
        ForecastType forecastType = new ForecastType();
        forecastType.setClouds(0f);
        forecastType.setMaxTemperature(0f);
        forecastType.setMinTemperature(0f);
        forecastType.setRain(0f);
        forecastType.setSnow(0f);
        forecastType.setTemperature(0f);

        PlaceType placeTypeOne = new PlaceType();
        placeTypeOne.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        placeTypeOne.setForecast(forecastType);
        placeTypeOne.setLatitude(new BigDecimal(45.65));
        placeTypeOne.setLongitude(new BigDecimal(54.32));
        placeTypeOne.setName("Dummy Restaurant");
        placeTypeOne.setOpeningHours("");
        placeTypeOne.setPlaceId("1234567890");
        placeTypeOne.setType("restaurant");
        placeTypeOne.setVicinity("Dummy street, Arnhem");

        PlaceType placeTypeTwo = new PlaceType();
        placeTypeTwo.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        placeTypeTwo.setForecast(forecastType);
        placeTypeTwo.setLatitude(new BigDecimal(45.65));
        placeTypeTwo.setLongitude(new BigDecimal(54.32));
        placeTypeTwo.setName("Dimmy Restaurant");
        placeTypeTwo.setOpeningHours("");
        placeTypeTwo.setPlaceId("0987654321");
        placeTypeTwo.setType("restaurant");
        placeTypeTwo.setVicinity("Dimmy street, Arnhem");

        DatePlannerResponse datePlannerResponse = new DatePlannerResponse();
        datePlannerResponse.getPlaces().add(placeTypeOne);
        datePlannerResponse.getPlaces().add(placeTypeTwo);

        return datePlannerResponse;
    }

}
