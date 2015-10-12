package nl.ead.dateplanner.services.application.openweather;

import java.util.Date;

public class Forecast {

    /**
     * Number of percentage of clouds
     */
    public Float clouds;

    /**
     * The maximum temperature of the day
     */
    public Float maximumTemperature;

    /**
     * The minimum temperature of the day
     */
    public Float minimumTemperature;

    /**
     * The number of cm rain for the day
     */
    public Float rain;

    /**
     * The number of cm snow for the day
     */
    public Float snow;

    /**
     * The temperature of the day part (morning, day, evening, night)
     */
    public Float temperature;

    /**
     * The date of the forecast
     */
    public Date date;

}
