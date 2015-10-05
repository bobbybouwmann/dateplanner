package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.DateOptions;
import nl.ead.dateplanner.services.DatePlannerResponse;
import nl.ead.dateplanner.services.application.IDateFinderService;
import nl.ead.dateplanner.services.DateDataType;

public class DateTaskService implements IDateTaskService {
    private final IDateFinderService dateFinder;

    public DateTaskService(IDateFinderService dateFinder) {
        this.dateFinder = dateFinder;
    }

    public DatePlannerResponse getDateOption(DateOptions options) {
        // TODO Use dateFinderService to retrieve information based on DateOptions
        String type = "restaurant";
        // options.getTypes()

        dateFinder.getDateOptions(type, "NL", options.getLocation(), options.getDayPart().value());

        DatePlannerResponse response = new DatePlannerResponse();
        DateDataType value = new DateDataType();
        response.setResult(value);
        return response;
    }
}
