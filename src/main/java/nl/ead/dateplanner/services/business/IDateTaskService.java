package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.DateOptions;
import nl.ead.dateplanner.services.DatePlannerResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

public interface IDateTaskService {

    DatePlannerResponse getDateOption(DateOptions options) throws IOException, DatatypeConfigurationException;

}
