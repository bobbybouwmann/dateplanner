package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.DateOptions;
import nl.ead.dateplanner.services.DatePlannerResponse;

public interface IDateTaskService {

    DatePlannerResponse getDateOption(DateOptions options);
}
