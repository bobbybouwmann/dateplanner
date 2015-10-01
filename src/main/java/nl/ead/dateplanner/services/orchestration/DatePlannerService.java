package nl.ead.dateplanner.services.orchestration;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.yahoo.Forecast;
import nl.ead.dateplanner.services.application.yahoo.WeatherData;
import nl.ead.dateplanner.services.application.yahoo.WeatherService;
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

    public DatePlannerService() {

    }

    @PayloadRoot(localPart = "DateplannerRequest", namespace = "http://www.han.nl/schemas/dateplanner")
    @ResponsePayload
    public DateplannerResponse getResults(@RequestPayload DateplannerRequest req) throws IOException {
        DateOptions options = req.getInput();

        DateplannerResponse response = new DateplannerResponse();

        DateDataType data = new DateDataType();

        // handle restraunt data
        RestaurantDataType restaurant = new RestaurantDataType();
        data.setRestaurantData(restaurant);

        WeatherService weatherService = new WeatherService();
        WeatherData weatherData = weatherService.retrieveWeather("Arnhem");

        List<Forecast> forecasts = weatherData.getForecasts();

        WeatherDataType weatherDataType = new WeatherDataType();

        for (int i = 0; i < forecasts.size(); i++) {
            ForecastType forecastType = new ForecastType();

            forecastType.setTemperature(forecasts.get(i).dayTemperature);
            forecastType.setMaxTemperature(forecasts.get(i).maximumTemperature);
            forecastType.setMinTemperature(forecasts.get(i).minimumTemperature);

            weatherDataType.getForecast().add(forecastType);
        }

        data.setWeatherData(weatherDataType);

        response.setResult(data);

        return response;
    }
}