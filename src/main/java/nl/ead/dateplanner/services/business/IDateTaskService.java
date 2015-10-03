package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.WeatherDataType;

import java.io.IOException;

public interface IDateTaskService {

    WeatherDataType retrieveWeather(String location, String dayPart) throws IOException;

}
