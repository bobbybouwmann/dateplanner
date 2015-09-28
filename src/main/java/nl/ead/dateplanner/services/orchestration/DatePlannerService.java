package nl.ead.dateplanner.services.orchestration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import nl.ead.dateplanner.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

@Endpoint
public class DatePlannerService {

    @Autowired
    public DatePlannerService() {

    }

    @PayloadRoot(localPart = "DateplannerRequest", namespace = "http://www.han.nl/schemas/dateplanner")
    @ResponsePayload
    public DateplannerResponse getResults(@RequestPayload DateplannerRequest req) {
        DateOptions options = req.getInput();

        DateplannerResponse response = new DateplannerResponse();

        DateDataType data = new DateDataType();

        // handle restraunt data
        RestaurantDataType restaurant = new RestaurantDataType();
        restaurant.setId("id");
        restaurant.setLocation("Arhnem");
        restaurant.setName("My name");
        restaurant.setType("Chinees");
        restaurant.setOpeningHours("0:00");
        restaurant.setVicinity("blablabla");
        data.setRestaurantData(restaurant);

        // Handle weather data
        WeatherDataType weatherData = new WeatherDataType();
        weatherData.setLocation("hello locat");
        weatherData.setAstronomy("hello astrom");
        weatherData.setForecast(BigDecimal.ONE);
        data.setWeatherData(weatherData);

        response.setResult(data);

        return response;
    }
}