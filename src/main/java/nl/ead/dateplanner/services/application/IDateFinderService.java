package nl.ead.dateplanner.services.application;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IDateFinderService {

    List<DateOption> getDateOptions(String type, String location, String dayPart, Double radius) throws IOException;

}
