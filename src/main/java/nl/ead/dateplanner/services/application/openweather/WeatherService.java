package nl.ead.dateplanner.services.application.openweather;

import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.aksingh.owmjapis.OpenWeatherMap.Units.METRIC;

public class WeatherService implements IWeatherService {

    private String OPEN_WEATHER_API_KEY;

    /**
     * Set the api key on construct.
     *
     * @throws FileNotFoundException
     */
    public WeatherService() throws FileNotFoundException {
        OPEN_WEATHER_API_KEY = getAPIKey("owapi.txt");
    }

    /**
     * Number of days to retrieve the weather.
     */
    private Byte days = 7;

    /**
     * Retrieve the weather based on the location (latitude, longitude).
     * Also set the temperature based on the day part.
     *
     * @param latitude Location latitude
     * @param longitude Location longitude
     * @param dayPart Day part for the forecast
     *
     * @return Return a list of forecasts.
     * @throws IOException
     */
    public List<Forecast> retrieveWeather(Float latitude, Float longitude, String dayPart) throws IOException {
        OpenWeatherMap owm = new OpenWeatherMap(METRIC, OPEN_WEATHER_API_KEY);
        DailyForecast dailyForecast = owm.dailyForecastByCoordinates(latitude, longitude, days);

        List<Forecast> forecasts = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            DailyForecast.Forecast currentForecast = dailyForecast.getForecastInstance(i);

            Forecast forecast = this.createForecast(currentForecast, dayPart);

            forecasts.add(forecast);
        }

        return forecasts;
    }

    /**
     * Create the Forecast object with all the necessary data.
     *
     * @param currentForecast DailyForecast.Forecast
     * @param dayPart Part of the day
     * @return Forecast
     */
    private Forecast createForecast(DailyForecast.Forecast currentForecast, String dayPart) {
        Forecast forecast = new Forecast();

        forecast.temperature = this.getTemperatureByDayPart(currentForecast, dayPart);
        forecast.maximumTemperature = currentForecast.getTemperatureInstance().getMaximumTemperature();
        forecast.minimumTemperature = currentForecast.getTemperatureInstance().getMinimumTemperature();
        forecast.clouds = currentForecast.getPercentageOfClouds();
        forecast.rain = currentForecast.getRain();
        forecast.snow = currentForecast.getSnow();
        forecast.clouds = currentForecast.getPercentageOfClouds();
        forecast.date = currentForecast.getDateTime();

        return forecast;
    }

    /**
     * Get the temperature based on the day part.
     *
     * @param currentForecast DailyForecast.Forecast
     * @param dayPart Part of the day
     * @return Float
     */
    private Float getTemperatureByDayPart(DailyForecast.Forecast currentForecast, String dayPart) {
        Float temperature;

        switch(dayPart) {
            case "morning":
                temperature = currentForecast.getTemperatureInstance().getMorningTemperature();
            break;

            case "day":
                temperature = currentForecast.getTemperatureInstance().getDayTemperature();
            break;

            case "evening":
                temperature = currentForecast.getTemperatureInstance().getEveningTemperature();
            break;

            case "night":
                temperature = currentForecast.getTemperatureInstance().getNightTemperature();
            break;

            default:
                temperature = currentForecast.getTemperatureInstance().getDayTemperature();
            break;
        }

        return temperature;
    }

    /**
     * Get the Open Weather API key from the file
     *
     * @param fileName File in which the API key is stored
     *
     * @return Open Weather API key
     * @throws FileNotFoundException
     */
    private String getAPIKey(String fileName) throws FileNotFoundException {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                result.append(scanner.nextLine());
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();

            throw e;
        }

        return result.toString();
    }
}