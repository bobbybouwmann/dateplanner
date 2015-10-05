package nl.ead.dateplanner.services.application;

import java.util.List;

/**
 * Created by Thomas Kooi on 5-10-2015.
 */
public interface IDateFinderService {

    List<DateOption> getDateOptions(String type, String countryCode, String location, String dayPart);
}
