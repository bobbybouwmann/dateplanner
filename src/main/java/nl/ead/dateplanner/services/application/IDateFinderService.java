package nl.ead.dateplanner.services.application;

import java.io.IOException;
import java.util.List;

public interface IDateFinderService {

    /**
     * Get date options with places and forecasts
     * @param type The type of places
     * @param location The location where we want to search for places
     * @param dayPart What part of the day do we want to plan a date
     * @param radius How far away from the location do we want to find dates
     * @return Date options with places and forecasts. Empty list if nothing could be found
     * @throws IOException
     */
    List<DateOption> getDateOptions(String type, String location, String dayPart, Double radius) throws IOException;

}
